<template>
    <sui-container class="main" text>
        <sui-header size="huge">Semantic UI Vue Fixed Template</sui-header>
        <p>This is a basic fixed menu template using fixed size containers.</p>
        <p>
            A text container is used for the main container, which is useful for single column layouts.
        </p>

        <h1>{{ msg }}</h1>
        <h2>Essential Links</h2>

        <h2 is="sui-header">Dogs Roles with Humans</h2>
        <p>
            Domestic dogs inherited complex behaviors, such as bite inhibition, from
            their wolf ancestors, which would have been pack hunters with complex body
            language. These sophisticated forms of social cognition and communication
            may account for their trainability, playfulness, and ability to fit into
            human households and social situations, and these attributes have given
            dogs a relationship with humans that has enabled them to become one of the
            most successful species on the planet today.
        </p>

        <p>
            The dogs' value to early human hunter-gatherers led to them quickly
            becoming ubiquitous across world cultures. Dogs perform many roles for
            people, such as hunting, herding, pulling loads, protection, assisting
            police and military, companionship, and, more recently, aiding handicapped
            individuals. This impact on human society has given them the nickname
            "man's best friend" in the Western world. In some cultures, however,
            dogs are also a source of meat.
        </p>

<!--        <sui-image src="/static/bundle/assets/logo.png" size="mini" centered/>-->
        <sui-image src="/static/bundle/assets/logo.png" centered/>
    </sui-container>
</template>

<script>
    export default {
        name: 'Home',
        data() {
            return {
                msg: 'Welcome to Your Vue.js App'
            }
        },
        created() {
            this.$http.get('/api/hello')
                .then(result => this.msg = result.data)
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>


</style>
