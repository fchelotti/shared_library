import groovy.json.JsonSlurper
def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text
def value = token.replaceAll("\"", "") 

def brazil = []
def folders = []
def brazilFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?datacenters=datacenter-11252", "-H", "vmware-api-session-id: ${value}"].execute().text
def brazilParse = new JsonSlurper().parseText( brazilFolders )
brazilParse.each{ brazil.push(it.name) }
brazilParse.each{ folders.push(it.folder) }

Map list = [folders, brazil].transpose().collectEntries()
def list2 = []
list.keySet().each{ list2.push(it) }

return list.find{ it.value == "host" }.key
