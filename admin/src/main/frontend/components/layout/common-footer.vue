<template>
    <sui-segment inverted vertical class="footer">
        <sui-container fluid text-align="center">
            <sui-grid class="inverted" stackable divided>
                <sui-grid-row>
                    <sui-grid-column :width="3" v-for="n in 3" :key="n">
                        <sui-list class="inverted" link>
                            <h4 is="sui-header" :content="`Group ${n}`" class="inverted"/>
                            <a is="sui-list-item" href="#">Link One</a>
                            <a is="sui-list-item" href="#">Link Two</a>
                            <a is="sui-list-item" href="#">Link Three</a>
                            <a is="sui-list-item" href="#">Link Four</a>
                        </sui-list>
                    </sui-grid-column>
                    <sui-grid-column :width="3">
                        <h4 is="sui-header" content="Footer Header" class="inverted"/>
                        <p>
                            Extra space for a call to action inside the footer that could help re-engage users.
                        </p>
                    </sui-grid-column>
                </sui-grid-row>
            </sui-grid>

            <sui-divider inverted section/>

            <sui-list
                horizontal
                divided
                link
                class="inverted">

                <a is="sui-list-item" href="#">Site Map</a>
                <a is="sui-list-item" href="#">Contact Us</a>
                <a is="sui-list-item" href="#">Terms and Conditions</a>
                <a is="sui-list-item" href="#">Privacy Policy</a>
            </sui-list>
        </sui-container>
    </sui-segment>
</template>

<script>
    export default {
        name: "common-footer"
    }
</script>

<style scoped>
    .footer {
        margin: 5em 0em 0em;
        padding: 5em 0em;
    }
</style>
