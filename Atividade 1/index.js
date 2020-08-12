class Record {
    constructor(name, email, birth, services){
        this.name = name
        this.email = email
        this.birth = birth
        this.services = services
    }
}

var arrayRecords = []

function getServices(){
    const optionsServices = document.querySelectorAll("input[type='checkbox']")
    
    let optionsFiltered = []
    for (let i=0; i< optionsServices.length; i++)
        if(optionsServices[i].checked)
            optionsFiltered.push(i)

    return optionsFiltered

}
function getValues(){
    const name = document.querySelector("input[name='name']").value
    const email = document.querySelector("input[name='email']").value
    const birth = document.querySelector("input[name='birth']").value
    
    const services = getServices()

    const record = new Record(name, email, birth, services)
    return record
}

function add(){
    const record = getValues()
    arrayRecords.push(record)

    buildTable()
    console.log(`name: ${record.name} email: ${record.email} birth: ${record.birth}`)
}

function buildTable(){
    const tableEL = document.querySelector("table")

    for(record in arrayRecords){
        const trEl = document.createElement("tr")
        const tdName = document.createElement("td")
        const tdEmail = document.createElement("td")
        const tdBirth = document.createElement("td")
        const tdServices = document.createElement("td")
        const tdTotal = document.createElement("td")

        tdName.value = record.name
        tdEmail.value = record.email
        tdBirth.value = record.birth

        const [services, total] = returnServicesAndTotal(record.services)
        tdServices.value = services
        tdTotal.value = total
        
        trEl.append(tdName, tdEmail, tdBirth, tdServices, tdTotal)
        tableEL.appendChild(trEl)
    }
}

function returnServicesAndTotal(services) {
    let textServices = ""
    let total = 0
    if( services.include(0)){
        textServices +="Processing - 1 micro - $ 1,00 per hour\n"
        total +=1
    }
    if( services.include(1)){
        textServices +="Processing - 1 medium - $ 2,00 per hour\n"
        total +=2
    }
    if( services.include(2)){
        textServices += "Processing - 1 large - $ 10,00 per hour\n"
        total +=10
    }
    if( services.include(3)){
        textServices +="Storage - 10 GB HD - $ 0,5 per hour\n"
        total +=0.5
    }
    if( services.include(4)){
        textServices +="Storage - 1 TB HD - $ 1,00 per hour\n"
        total +=1
    }
    if( services.include(5)){
        textServices +="Storage - 100 GB SSD - $ 5,00 per hour\n"
        total +=5
    }

    return [textServices, total]
}

