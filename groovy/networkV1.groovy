import groovy.json.JsonSlurper

def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text;
def value = token.replaceAll("\"", "");
def network = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/network?datacenters=datacenter-11252", "-H", "vmware-api-session-id: ${value}"].execute().text;
def list = [];
dataStoreParse = new JsonSlurper().parseText( network )
def result = dataStoreParse.findResults { it.name.contains("BACKUP") ? it.name: null}

println(result)