const path = require('path');

const baseConfig = require('./webpack.config.base');
const webpackMerge = require('webpack-merge');

const OptimizeCssnanoPlugin = require('@intervolga/optimize-cssnano-plugin');

module.exports = webpackMerge(baseConfig, {
    mode: 'production',
    output: {
        filename: '[name].js',
        path: path.resolve(__dirname, 'target/prepare/static/bundle'),
    },
    optimization: {
        minimizer: [
            new OptimizeCssnanoPlugin({
                sourceMap: false,
                cssnanoOptions: {
                    preset: [
                        'default',
                        {
                            discardComments: {
                                removeAll: true,
                            },
                        },
                    ],
                },
            }),
        ],
    },
    performance: {
        hints: false,
        maxEntrypointSize: 512000,
        maxAssetSize: 512000
    },
    plugins: [

    ],
});
