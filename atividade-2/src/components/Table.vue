<template>
    <div id="results-table" class="table-responsive">
        <table id="table" class="table table-hover table-striped table-bordered">
            <thead class="thead-light">
                <tr>
                    <th>Name</th>
                    <th>E-mail</th>
                    <th>Date of Birth</th>
                    <th>Services</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(record,index) in records"
                    v-bind:key="index"
                >
                    <td>{{record.name}}</td>
                    <td>{{record.email}}</td>
                    <td>{{record.birth | formattedDate}}</td>
                    <td>{{record.services | getDescriptions}}</td>
                    <td>{{record.services | getValueTotal}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>

import {getDescriptionsService, getValueTotalServices} from '../utils/Services'

export default {
    name: 'Table',
    props: {
        records: Array
    },
    filters: {
        getDescriptions(idArray) {
            return getDescriptionsService(idArray)
        },
        getValueTotal(idArray) {
            return `$ ${getValueTotalServices(idArray)} per hour`
        },
        formattedDate(date) {
            let dateArray = date.split("-")
            return `${dateArray[2]}/${dateArray[1]}/${dateArray[0]}`
        }
    }
}
</script>

<style>
#results-table {
    margin: 32px 0;
    max-width: 1300px;
}

table {
    min-width: 1100px;
}

thead {
    border-top: 2px solid #303030;
}

th {
    font-weight: 500;
}

th, td {
    min-width: 90px;
    min-height: 30px;

    text-align: center;
}
</style>