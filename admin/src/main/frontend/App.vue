<template>
    <sui-sidebar-pushable>
        <sui-sidebar animation="overlay" class="inverted" :visible="visible">
            <!-- links -->
            <a class="item">
                <i class="sticky note icon"></i>
                Bulletin
            </a>
            <a class="item">
                <i class="newspaper icon"></i>
                News
            </a>
            <a class="item">
                <i class="mail icon"></i>
                Contact us
            </a>
        </sui-sidebar>
        <sui-sidebar-pusher :dimmed="visible" @click="visible = false">
            <sui-menu fixed inverted>
                <sui-container fluid>
                    <a is="sui-menu-item" @click.stop="visible = true">Menu</a>

                    <a href="#" is="sui-menu-item" class="header">
                        Admin Console
                    </a>

                    <a is="sui-menu-item" href="#">Home</a>

                    <sui-dropdown text="Dropdown" item class="simple">
                        <sui-dropdown-menu>
                            <a is="sui-dropdown-item" href="#">Link Item</a>
                            <a is="sui-dropdown-item" href="#">Link Item</a>

                            <sui-dropdown-divider/>
                            <sui-dropdown-header>Header Item</sui-dropdown-header>

                            <sui-dropdown-item>
                                <sui-icon name="dropdown"/>
                                Submenu

                                <sui-dropdown-menu class="simple">
                                    <a is="sui-dropdown-item" href="#">Link Item</a>
                                    <a is="sui-dropdown-item" href="#">Link Item</a>
                                </sui-dropdown-menu>
                            </sui-dropdown-item>

                            <a is="sui-dropdown-item" href="#">Link Item</a>
                        </sui-dropdown-menu>
                    </sui-dropdown>
                </sui-container>
            </sui-menu>

            <router-view/>

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
        </sui-sidebar-pusher>
    </sui-sidebar-pushable>
</template>

<script>
    export default {
        name: 'App',
        data: () => ({
            visible: false
        }),

    }
</script>

<style>
    html, body {
        min-height: 100%;
        overflow: hidden
    }

    .main {
        margin-top: 70px;
        height: inherit;
    }

    .footer {
        margin: 5em 0em 0em;
        padding: 5em 0em;
    }
</style>

