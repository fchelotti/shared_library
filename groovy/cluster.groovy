import groovy.json.JsonSlurper
def prod = []
def dr = []
def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text
def value = token.replaceAll("\"", "")
def response = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/datacenter?folders=group-d5008", "-H", "vmware-api-session-id: ${value }"].execute().text
def drResponse = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/datacenter?folders=group-d5009", "-H", "vmware-api-session-id: ${value }"].execute().text
def list = new JsonSlurper().parseText( response )
def drList = new JsonSlurper().parseText( drResponse )
list.each { prod.push(it.name) }
drList.each { dr.push(it.name) }

if (DataCenter.equals("01-PROD")) {
  return prod
} else {
  return dr
}
