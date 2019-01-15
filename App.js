// @flow
import React from 'react'
import type Node from 'react'

import Screensaver from './src/feature/Screensaver'

export default class App extends React.Component<void> {
  render (): Node {
    return (
      <Screensaver />
    )
  }
}
