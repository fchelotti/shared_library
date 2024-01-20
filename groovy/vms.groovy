import groovy.json.JsonSlurper
def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text
def value = token.replaceAll("\"", "") 

def vms = []
def vmsList = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/vm?folders=${Folders}", "-H", "vmware-api-session-id: ${value}", "|awk", "'{print \$1}'"].execute().text
def vmsParse = new JsonSlurper().parseText( vmsList )
vmsParse.each{ vms.push(it.name) }

return vms.sort{ it }
