import groovy.json.JsonSlurper
 
def Folder() {
    def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text
    def value = token.replaceAll("\"", "")
    brazil = []
    folders = []
    brazilFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?datacenters=datacenter-11252", "-H", "vmware-api-session-id: ${value}"].execute().text
    brazilParse = new JsonSlurper().parseText( brazilFolders )
    brazilParse.each{ brazil.push(it.name) }
    brazilParse.each{ folders.push(it.folder) }
    
    Map list = [folders, brazil].transpose().collectEntries()
    list2 = []
    list.keySet().each{ list2.push(it) }
    
    return list
}
 
folderSelect = Folder()["group-n29728"]
 
println(folderSelect)
 
println(Folder().find{ it.value == folderSelect }.key)
 
//println(folderSelect.key)
