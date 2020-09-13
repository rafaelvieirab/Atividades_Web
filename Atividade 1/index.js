class Record {
    constructor(name, email, birth, services){
        this.name = name
        this.email = email
        this.birth = birth
        this.services = services
    }
}

var arrayServices = [
    {
        id:"cpu-micro",
        description: "Processing - 1 micro - $ 1,00 per hour",
        valueByHour: 1
    },
    {
        id:"cpu-medium",
        description: "Processing - 1 medium - $ 2,00 per hour",
        valueByHour: 2
    },
    {
        id:"cpu-large",
        description: "Processing - 1 large - $ 10,00 per hour",
        valueByHour: 10
    },
    {
        id:"hd-10gb",
        description: "Storage - 10 GB HD - $ 0,50 per hour",
        valueByHour: 0.5
    },
    {
        id:"hd-1tb",
        description: "Storage - 1 TB HD - $ 1,00 per hour",
        valueByHour: 1
    },
    {
        id:"ssd-100gb",
        description: "Storage - 100 GB - $ 5,00 per hour",
        valueByHour: 5
    },
    
]

var arrayRecords = []

function clearFields(){
    const nameEl = document.querySelector("input[name='name']")
    const emailEl = document.querySelector("input[name='email']")
    const birthEl = document.querySelector("input[name='birth']")
    const optionsEl = document.querySelectorAll("input[type='checkbox']:checked")
    
    nameEl.value = ""
    emailEl.value = ""
    birthEl.value = ""
    optionsEl.forEach( inputEl => inputEl.checked=false)
}

function checkFieldsFilling(name, email, birth, services){
    if (name === "" || email === "" || birth === "" || services.length === 0) {
        alert("Preencha todos os campos")
        return false
    }
    if( email.search(/\w+@[a-z]+.[a-z]+/) === -1) {
        alert("Digite um email valido!")
        return false
    }
    return true
}

function getValues(){
    const name = document.querySelector("input[name='name']").value
    const email = document.querySelector("input[name='email']").value
    const birth = document.querySelector("input[name='birth']").value
    const optionsEl = document.querySelectorAll("input[type='checkbox']:checked")
    
    let inputIds = []
    optionsEl.forEach(inputEl => inputIds.push(inputEl.id))

    if (! checkFieldsFilling(name, email, birth, inputIds)) {
        return null
    }

    const record = new Record(name, email, birth, inputIds)
    return record
}

function addInfo(event){
    event.preventDefault()
    const record = getValues()

    if(record !== null) {
        arrayRecords.push(record)
        clearFields()
        buildTable()
    }
}

function buildTable(){
    const tbodyEL = document.querySelector("tbody")
    tbodyEL.innerHTML = ""

    arrayRecords.forEach( record =>{
        const trEl = document.createElement("tr")
        const tdName = document.createElement("td")
        const tdEmail = document.createElement("td")
        const tdBirth = document.createElement("td")
        const tdServices = document.createElement("td")
        const tdTotal = document.createElement("td")

        tdName.textContent = record.name
        tdEmail.textContent = record.email
        tdBirth.textContent = record.birth

        const [services, total] = returnServicesAndTotal(record.services)
        tdServices.innerHTML = services
        tdTotal.textContent = total
        
        trEl.append(tdName, tdEmail, tdBirth, tdServices, tdTotal)
        tbodyEL.appendChild(trEl)
    })
}

function returnServicesAndTotal(services) {
    let textServices = ""
    let total = 0

    services.forEach(idService => {
        for(let itemService in arrayServices){
            if (arrayServices[itemService].id === idService){
                textServices += `${arrayServices[itemService].description} ${"\n"}`
                total += arrayServices[itemService].valueByHour
            }
        }
    });

    const textTotal = `$ ${total} per hour`
    return [textServices, textTotal]
}