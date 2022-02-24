const { VueLoaderPlugin } = require('vue-loader')
const HtmlPlugin = require('html-webpack-plugin')
const CopyPlugin = require('copy-webpack-plugin')
const webpack = require('webpack')

module.exports = (env, options) => {
  console.log(env, options)
  return {
    resolve: {
      extensions: ['.js', '.vue'],
      alias: {
        '~': `${__dirname}/src`,
        process: 'process/browser',
      },
      fallback: { 
        'util': require.resolve('util/'),
      },
    },
    entry: './src/main.js',
    output: {
      publicPath: '/',
      clean: true
    },
    module: {
      rules: [
        {
          test: /\.js$/,
          exclude: /node_modules/,
          use: 'babel-loader'
        },
        {
          test: /\.vue$/,
          use: 'vue-loader'
        },
        {
          test: /\.s?css$/,
          use: [
            'vue-style-loader',
            'css-loader',
            'postcss-loader',
            {
              loader: 'sass-loader',
              options: {
                additionalData: `
                  @use "sass:color";
                  @use "sass:list";
                  @use "sass:map";
                  @use "sass:math";
                  @use "sass:meta";
                  @use "sass:selector";
                  @use "sass:string";
                  @import "~/scss/_variables";
                `
              }
            }
          ]
        },
        {
          test: /\.svg$/,
          use: [
            'vue-loader',
            'vue-svg-loader',
          ],
        },
      ]
    },
    plugins: [
      new VueLoaderPlugin(),
      new HtmlPlugin({
        template: './src/index.html'
      }),
      new CopyPlugin({
        patterns: [
          { from: 'static' }
        ]
      }),
      new webpack.ProvidePlugin({
        process: 'process/browser',
      }),    
      new webpack.DefinePlugin({
        'process.env': JSON.stringify(require('./s3.config.json')),
      }),
    ],
    devServer: {
      port: 8000,
      historyApiFallback: true
    }
  }
}
