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

def user = ""
def pass = ""

for (creds in jenkinsCredentials) {
    if(creds.id == "vmUser"){
        user = creds.username
        pass = creds.password
    }
}

def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text
def value = token.replaceAll("\\"", "")

def vms = []
def vmsList = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/vm?folders=${Folder}", "-H", "vmware-api-session-id: ${value}"].execute().text
def vmsParse = new JsonSlurper().parseText( vmsList )
vmsParse.each{ vms.push(it.name) }

if (vms.contains(VMname.toUpperCase())) {
    return "This name ALREADY EXIST in this Folder"
} else {
    return "This name is AVAILABLE"
}
