<template>
    <div>
        <form action="" method="POST">
            <label for="name">Nome</label>
            <input type="text" id="name" v-model="name" placeholder="Digite seu nome">

            <label for="office">Cargo</label>
            <input type="text" id="office" v-model="office" placeholder="Digite seu cargo">

            <label for="birthDate">Data de Nascimento</label>
            <input type="date" id="birthDate" v-model="birthDate" min="1950-01-01" max="2020-10-10">
            
            <label for="entryDate">Data de Entrada na Empresa</label>
            <input type="date" id="entryDate" v-model="entryDate"  min="1950-01-01" max="2020-10-10">

            <button type="submit" @click="addEmployee">Cadastrar</button>
        </form>
    </div>
</template>

<script>
export default {
    name: "Register",
    data() {
        return {
            name: "",
            office: "",
            birthDate:"",
            entryDate:"",
            baseURI: "http://localhost:8080/server/api"
        }
    },
    methods: {
        addEmployee: function() {
            let employee = {
                name = this.name,
                office = this.office,
                birthDate = this.birthDate,
                entryDate = this.entryDate
            }
            this.$http.post(this.baseURI, employee).then(result => {

            })
        }
    }
}
</script>

<style>

</style>