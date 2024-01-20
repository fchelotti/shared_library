import groovy.json.JsonSlurper

def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text;
def value = token.replaceAll("\"", "");

def kbToGb(int kiloBytes) {
    double gigaBytes = kiloBytes / 1024 / 1024
    return gigaBytes
};

def dataStore = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/datastore?datastores=datastore-1013443&datacenters=datacenter-11252", "-H", "vmware-api-session-id: ${value}"].execute().text;
def dataStoreParse = new JsonSlurper().parseText( dataStore );
def dataStoreCapacity  = dataStoreParse.findResults { it.free_space };
def dataStoreFree = dataStoreParse.findResults { it.free_space };

return "DataStore Capacity: " + kbToGb(dataStoreCapacity[0]) + " GB" + " | " + "DataStore Free: " + kbToGb(dataStoreFree[0]) + " GB";
