const arrayServices = [
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
    }   
]

export function getDescriptionsService(idArray) {
    str = ""
    arrayServices.forEach(itemService => {
        if(idArray.includes(itemService.id)) 
            str +=  "${itemService.description}\n"
    })
    return str
}

export function getValueTotalServices(idArray) {
    total = 0
    arrayServices.forEach(itemService => {
        if(idArray.includes(itemService.id)) 
            total += itemService.valueByHour
    })
    return total
}