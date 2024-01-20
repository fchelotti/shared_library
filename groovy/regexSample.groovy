// Running on Groovy 3.0.3

assert "v3.12.4" ==~ /v\d{1,3}\.\d{1,3}\.\d{1,3}/

def aString = 'CMB-DMZ-DATA-TN-271'
def matcher = aString.findAll(/\d{1,3}.?\d{2,3}?/)
print matcher[0]
