<template>
    <div>
        <h1>Url da Imagem do álbum 3</h1>
        <ul>
            <li v-for="photo in photos" :key="photo.id">{{photo.url}}</li>
        </ul>
    </div>
</template>

<script>
export default {
    name: 'Photos',
    data: function() {
        return {
            photos: [],
            baseURI: 'https://jsonplaceholder.typicode.com/photos'
        }
    },
    mounted: function() {
        this.$http.get(this.baseURI)
            .then(result => {
                this.photos = result.data.filter(photo => {
                    return photo.albumId === 3
                })
            }).catch(() => console.log("Ocorreu um problema"))
    }
}
</script>

<style>
    li {
        list-style: none;
    }
</style>