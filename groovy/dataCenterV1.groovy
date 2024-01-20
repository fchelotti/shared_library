def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text
def value = token.replaceAll("\"", "")

def prodName = []
def drName = []
def prodID = []
def drID = []

def prodResponse = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/datacenter?folders=group-d5008", "-H", "vmware-api-session-id: ${value}"].execute().text
def drResponse = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/datacenter?folders=group-d5009", "-H", "vmware-api-session-id: ${value}"].execute().text
def prodList = new JsonSlurper().parseText( prodResponse )
def drList = new JsonSlurper().parseText( drResponse )

prodList.each { prodName.push(it.name) }
prodList.each { prodID.push(it.datacenter) }
Map prodResult = [prodID, prodName].transpose().collectEntries()

drList.each { drName.push(it.name) }
drList.each { drID.push(it.datacenter) }
Map drResult = [drID, drName].transpose().collectEntries()

if (Environments.equals("01-PROD")) {
    env.resultDataCenter = prodResult[params.DataCenter]
} else {
    env.resultDataCenter = drResult[params.DataCenter]
}

def folderName = []
def folderID = []
def folderResponse = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=${DataCenter}", "-H", "vmware-api-session-id: ${value}"].execute().text
def folderParse = new JsonSlurper().parseText( folderResponse )
folderParse.each{ folderName.push(it.name) }
folderParse.each{ folderID.push(it.folder) }

Map folderList = [folderID, folderName].transpose().collectEntries()
env.resultFolder = folderList[params.Folder]

env.vlanID = params.NetworkData.findAll(/\d{1,3}.?\d{2,3}?/)
vlanID = vlanID.replaceAll(~/[\[\]]/, '')
