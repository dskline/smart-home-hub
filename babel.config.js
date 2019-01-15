module.exports = function (api) {
  api.cache(true)
  return {
    presets: [
      'babel-preset-expo',
      'babel-preset-flow'
    ],
    plugins: [
      '@babel/transform-react-jsx-source',
      [
        'module-resolver',
        {
          root: ['./src'],
          alias: {
            src: './src'
          }
        }
      ]
    ]
  }
}
