import groovy.json.JsonSlurper

def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text;
def value = token.replaceAll("\"", "");
def dataStore = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/datastore?datacenters=datacenter-11252", "-H", "vmware-api-session-id: ${value}"].execute().text;
def list = [];
dataStoreParse = new JsonSlurper().parseText( dataStore )

println(dataStore)

//println(dataStoreParse.collectEntries { it.capacity })
//dataStoreParse.findResults { it.free_space > it.capacity * 0.3 ? it.name : null }
dataStoreParse.collectEntries {
 if (it.free_space > it.capacity * 0.3) {
    ["${it.name}": it.free_space * 1024 >> 40]
  } else {
    [:]
  }
}

// dataStore.each{ totalSpace.push(it.space) }
// dataStore.each{ freeSpace.push(it.free_space) }

//println(name)
//println(totalSpace)
//println(freeSpace)