<template>
    <div id="fields">
        <form id="form" v-on:submit.prevent="onSubmit" class="needs-validation">

            <div class="row form-group field-input">
                <label class="col-sm-3" for="name">Name</label>
                <input type="text" v-model="name" class="col-sm-9 form-control" name="name" placeholder="Digite seu nome" required>
            </div>
            <div class="row form-group field-input">
                <label class="col-sm-3" for="email">E-mail</label>
                <input type="email" v-model="email" class="col-sm-9 form-control" name="email" placeholder="Digite seu email" required>
            </div>
            <div class="row form-group field-input">
                <label class="col-sm-3" for="birth">Date of birth</label>
                <input type="date" v-model="birth" class="col-sm-9 form-control" name="birth" required>
            </div>
            
            <div class="row field-input d-flex flex-row justify-content-around">
                <label class="col-sm-3" >Services</label>
                <div id="optionsServices" class="row col-sm-9">
                    <div class="halfOptions col-sm-6">
                        <div class="custom-control custom-checkbox">
                            <input v-model="optionsServices" value="cpu-micro" type="checkbox" id="cpu-micro" class="custom-control-input">
                            <label for="cpu-micro" class="custom-control-label">Processing - 1 micro - $ 1,00 per hour</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <input v-model="optionsServices" value="cpu-medium" type="checkbox"  id="cpu-medium" class="custom-control-input">
                            <label for="cpu-medium" class="custom-control-label">Processing - 1 medium - $ 2,00 per hour</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <input v-model="optionsServices" value="cpu-large" type="checkbox" id="cpu-large" class="custom-control-input">
                            <label for="cpu-large" class="custom-control-label">Processing - 1 large - $ 10,00 per hour</label>
                        </div>
                    </div>
                    <div class="halfOptions col-sm-6">
                        <div class="custom-control custom-checkbox">
                            <input v-model="optionsServices" value="hd-10gb" type="checkbox" id="hd-10gb" class="custom-control-input">
                            <label for="hd-10gb" class="custom-control-label">Storage - 10 GB HD - $ 0,5 per hour</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <input v-model="optionsServices" type="checkbox" value="hd-1tb" id="hd-1tb" class="custom-control-input">
                            <label for="hd-1tb" class="custom-control-label">Storage - 1 TB HD - $ 1,00 per hour</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <input v-model="optionsServices" type="checkbox" value="ssd-100gb" id="ssd-100gb" class="custom-control-input">
                            <label for="ssd-100gb" class="custom-control-label">Storage - 100 GB SSD - $ 5,00 per hour</label>
                        </div>
                    </div>
                </div>
            </div>
            <footer id="buttons" class="d-flex flex-row justify-content-center">
                <button type="reset" class="btn btn-secondary">CLEAR</button>
                <button type="submit" v-on:click.prevent="add" class="btn btn-primary">ADD</button>
            </footer>
        </form>
    </div>
</template>

<script>
import Record from '../utils/Record';

function verifyAge(birth) {
    let birthDate = birth.split("-")
    let now = new Date();
    let age = now.getFullYear() - birthDate[0]

    if (now.getMonth()+1 < birthDate[1] || (now.getMonth()+1 == birthDate[1] && now.getDate() < birthDate[2])) 
        age--;
    return age < 18 
}

export default {
    name: 'Form',
    data: function() {
        return {
            name: "",
            email: "",
            birth: "",
            optionsServices: []
        }
    },
    methods: {
        add() {
            if(this.validation()) {
                let record = new Record(this.name, this.email, this.birth, this.optionsServices);
                this.records.push(record);
                localStorage.setItem("records", JSON.stringify(this.records));
                this.clearFields();
            }
        },
        clearFields() {
            this.name = "";
            this.email = "";
            this.birth = "";
            this.optionsServices = [];
        },
        validation() {
            if(this.name === "" || this.email === "" || this.birth === "" || this.optionsServices.length === 0){
                alert("Preencha todos os campos")
                return false
            }
            else if (this.email.search(/\w+@[a-z]+.[a-z]+/) === -1) {
                alert("Digite um email valido!")
                return false
            }
            else if (verifyAge(this.birth)) {
                alert("Você deve ter pelo menos 18 anos!!")
                return false
            }
            return true
        }
    }
}
</script>
header {
    margin-bottom: 32px;
}

#fields form .field-input {
    margin: 24px 0;
}

.field-input > input {
    text-align: center;
    border: #555252 1px solid;
}

input[type='checkbox'] {
    cursor: pointer;
}

#buttons {
    width: 100%;
}

button {
    width: 128px;
    height: 36px;
    margin: 16px  16px;

    background-color: #e3e3e3;
    color: #333333;
    border-radius: 16px;
    
    font-size: 16px;
    text-transform: uppercase;
    cursor: pointer;

    transition: 0.2s;
    border: none;
}

button:active {
    background-color: #e0e0e0;
}

button:hover {
    transform: scale(1.06, 1.06);
}
<style>

</style>