import groovy.json.JsonSlurper
def token = ["curl", "--insecure", "-XPOST", "-H", "Content-Type: application/json", "-H", "Accept: application/json", "-H", "vmware-use-header-authn: test", "-H", "vmware-api-session-id: null", "-u", "${user}:${pass}", "https://[informe a url do vcenter]/api/session"].execute().text
def value = token.replaceAll("\"", "")

if (Cluster.equals("BRASIL")) {
  def brazil = []
  def folders = []
  def brazilFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-11252", "-H", "vmware-api-session-id: ${value}"].execute().text
  def brazilParse = new JsonSlurper().parseText( brazilFolders )
  brazilParse.each{ brazil.push(it.name) }
  brazilParse.each{ folders.push(it.folder) }

  Map list = [folders, brazil].transpose().collectEntries()

  return list
}

if (Cluster.equals("GESTION-BR")) {
  def gestionBr = []
  def folders = []
  def gestionBrFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-1001", "-H", "vmware-api-session-id: ${value}"].execute().text
  def gestionBrParse = new JsonSlurper().parseText( gestionBrFolders )
  gestionBrParse.each{ gestionBr.push(it.name) }
  gestionBrParse.each{ folders.push(it.folder) }

  Map list = [folders, gestionBr].transpose().collectEntries()

  return list
}

if (Cluster.equals("DR-GESTION-US")) {
  def dRgestionBr = []
  def folders = []
  def dRgestionBrFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-1003752", "-H", "vmware-api-session-id: ${value}"].execute().text
  def dRgestionBrParse = new JsonSlurper().parseText( dRgestionBrFolders )
  dRgestionBrParse.each{ dRgestionBr.push(it.name) }
  dRgestionBrParse.each{ folders.push(it.folder) }

  Map list = [folders, dRgestionBr].transpose().collectEntries()

  return list
}

if (Cluster.equals("SURAMERICA")) {
  def surAmerica = []
  def folders = []
  def surAmericaFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-10064", "-H", "vmware-api-session-id: ${value}"].execute().text
  def surAmericaParse = new JsonSlurper().parseText( surAmericaFolders )
  surAmericaParse.each{ surAmerica.push(it.name) }
  surAmericaParse.each{ folders.push(it.folder) }

  Map list = [folders, surAmerica].transpose().collectEntries()

  return list
}

if (Cluster.equals("COMUN-BR")) {
  def comunBr = []
  def folders = []
  def comunBrFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-10759", "-H", "vmware-api-session-id: ${value}"].execute().text
  def comunBrParse = new JsonSlurper().parseText( comunBrFolders )
  comunBrParse.each{ comunBr.push(it.name) }
  comunBrParse.each{ folders.push(it.folder) }

  Map list = [folders, comunBr].transpose().collectEntries()

  return list
}

if (Cluster.equals("DR-APLICACIONES")) {
  def drAplicaciones = []
  def folders = []
  def drAplicacionesFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-109173", "-H", "vmware-api-session-id: ${value}"].execute().text
  def drAplicacionesParse = new JsonSlurper().parseText( drAplicacionesFolders )
  drAplicacionesParse.each{ drAplicaciones.push(it.name) }
  drAplicacionesParse.each{ folders.push(it.folder) }

  Map list = [folders, drAplicaciones].transpose().collectEntries()

  return list
}

if (Cluster.equals("DR-AMERICA-CENTRAL")) {
  def drAmericaCentral = []
  def folders = []
  def drAmericaCentralFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-12446", "-H", "vmware-api-session-id: ${value}"].execute().text
  def drAmericaCentralParse = new JsonSlurper().parseText( drAmericaCentralFolders )
  drAmericaCentralParse.each{ drAmericaCentral.push(it.name) }
  drAmericaCentralParse.each{ folders.push(it.folder) }

  Map list = [folders, drAmericaCentral].transpose().collectEntries()

  return list
}

if (Cluster.equals("ARGENTINA")) {
  def argentina = []
  def folders = []
  def argentinaFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-130679", "-H", "vmware-api-session-id: ${value}"].execute().text
  def argentinaParse = new JsonSlurper().parseText( argentinaFolders )
  argentinaParse.each{ argentina.push(it.name) }
  argentinaParse.each{ folders.push(it.folder) }

  Map list = [folders, argentina].transpose().collectEntries()

  return list
}

if (Cluster.equals("DR-PUERTO-RICO")) {
  def drPuertoRico = []
  def folders = []
  def drPuertoRicoFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-140715", "-H", "vmware-api-session-id: ${value}"].execute().text
  def drPuertoRicoParse = new JsonSlurper().parseText( drPuertoRicoFolders )
  drPuertoRicoParse.each{ drPuertoRico.push(it.name) }
  drPuertoRicoParse.each{ folders.push(it.folder) }

  Map list = [folders, drPuertoRico].transpose().collectEntries()

  return list
}

if (Cluster.equals("DR-ECUADOR-VENEZUELA")) {
  def drEcuadorVenezuela = []
  def folders = []
  def drEcuadorVenezuelaFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-181560", "-H", "vmware-api-session-id: ${value}"].execute().text
  def drEcuadorVenezuelaParse = new JsonSlurper().parseText( drEcuadorVenezuelaFolders )
  drEcuadorVenezuelaParse.each{ drEcuadorVenezuela.push(it.name) }
  drEcuadorVenezuelaParse.each{ folders.push(it.folder) }

  Map list = [folders, drEcuadorVenezuela].transpose().collectEntries()

  return list
}

if (Cluster.equals("DR-MEXICO")) {
  def drMexico = []
  def folders = []
  def drMexicoFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-267151", "-H", "vmware-api-session-id: ${value}"].execute().text
  def drMexicoParse = new JsonSlurper().parseText( drMexicoFolders )
  drMexicoParse.each{ drMexico.push(it.name) }
  drMexicoParse.each{ folders.push(it.folder) }

  Map list = [folders, drMexico].transpose().collectEntries()

  return list
}

if (Cluster.equals("DR-REPUBLICA-DOMINICANA")) {
  def drRepublicaDominicana = []
  def folders = []
  def drRepublicaDominicanaFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-5003", "-H", "vmware-api-session-id: ${value}"].execute().text
  def drRepublicaDominicanaParse = new JsonSlurper().parseText( drRepublicaDominicanaFolders )
  drRepublicaDominicanaParse.each{ drRepublicaDominicana.push(it.name) }
  drRepublicaDominicanaParse.each{ folders.push(it.folder) }

  Map list = [folders, drRepublicaDominicana].transpose().collectEntries()

  return list
}

if (Cluster.equals("DR-PERU")) {
  def drPure = []
  def folders = []
  def drPureFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-5010", "-H", "vmware-api-session-id: ${value}"].execute().text
  def drPureParse = new JsonSlurper().parseText( drPureFolders )
  drPureParse.each{ drPure.push(it.name) }
  drPureParse.each{ folders.push(it.folder) }

  Map list = [folders, drPure].transpose().collectEntries()

  return list
}

if (Cluster.equals("CHILE")) {
  def chile = []
  def folders = []
  def chileFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-66619", "-H", "vmware-api-session-id: ${value}"].execute().text
  def chileParse = new JsonSlurper().parseText( chileFolders )
  chileParse.each{ chile.push(it.name) }
  chileParse.each{ folders.push(it.folder) }

  Map list = [folders, chile].transpose().collectEntries()

  return list
}

if (Cluster.equals("DR-COLOMBIA")) {
  def drColombia = []
  def folders = []
  def drColombiaFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-79820", "-H", "vmware-api-session-id: ${value}"].execute().text
  def drColombiaParse = new JsonSlurper().parseText( drColombiaFolders )
  drColombiaParse.each{ drColombia.push(it.name) }
  drColombiaParse.each{ folders.push(it.folder) }

  Map list = [folders, drColombia].transpose().collectEntries()

  return drColombia
}

if (Cluster.equals("DR-ASISTENCIA-US")) {
  def drAsistenciaUs = []
  def folders = []
  def drAsistenciaUsFolders = ["curl", "--insecure", "-XGET", "https://[informe a url do vcenter]/api/vcenter/folder?type=VIRTUAL_MACHINE&datacenters=datacenter-92796", "-H", "vmware-api-session-id: ${value}"].execute().text
  def drAsistenciaUsParse = new JsonSlurper().parseText( drAsistenciaUsFolders )
  drAsistenciaUsParse.each{ drAsistenciaUs.push(it.name) }
  drAsistenciaUsParse.each{ folders.push(it.folder) }

  Map list = [folders, drAsistenciaUs].transpose().collectEntries()

  return list
}

return null
