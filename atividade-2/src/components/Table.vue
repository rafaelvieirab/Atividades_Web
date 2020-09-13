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
                    <td>{{record.birth}}</td>
                    <td>{{record.optionsServices | getDescriptions}}</td>
                    <td>{{record.optionsServices | getValueTotal}}</td>
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
            return getValueTotalServices(idsArray)
        }
    }
}
</script>

<style>
#results-table {
    margin: 32px 0;
    max-width: 1100px;
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