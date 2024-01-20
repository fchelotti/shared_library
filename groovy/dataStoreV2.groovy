import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*
import groovy.json.JsonSlurper

def jenkinsCredentials = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
        com.cloudbees.plugins.credentials.Credentials.class,
        Jenkins.instance,
        null,
        null
);

def user = "";
def pass = "";

for (creds in jenkinsCredentials) {
    if(creds.id == "vmUser"){
        user = creds.username
        pass = creds.password
    }
}

def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text
def value = token.replaceAll("\\"", "");

def dataStore = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/datastore?datacenters=${DataCenter}", "-H", "vmware-api-session-id: ${value}"].execute().text
def dataStoreParse = new JsonSlurper().parseText( dataStore );

def dataStoreFree = dataStoreParse.findResults { it.free_space > it.capacity * 0.3 ? it.name: null }

if (Cluster.contains("NODMZ")) {
    return dataStoreFree.findResults { it.contains("NODMZ") ? it: null}
} else {
    return dataStoreFree.findResults { it.contains("-DMZ") ? it: null}
}
