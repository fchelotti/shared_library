import groovy.json.JsonSlurper
def choices = []
def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text
def value = token.replaceAll("\"", "")
def response = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=DATACENTER", "-H", "vmware-api-session-id: ${value}"].execute().text
def list = new JsonSlurper().parseText( response )
list.each { choices.push(it.name) }
return choices[0..1]
