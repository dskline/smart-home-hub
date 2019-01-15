// @flow
import React from 'react'
import type Node from 'react'
import { StatusBar, StyleSheet, View } from 'react-native'

import ClockWidget from './widget/ClockWidget'

export default class Screensaver extends React.Component<void> {

  componentDidMount (): void {
    StatusBar.setHidden(true)
  }

  render (): Node {
    return (
      <View style={styles.window}>
        <ClockWidget />
      </View>
    )
  }
}

const styles = StyleSheet.create({
  window: {
    backgroundColor: '#000',
    width: '100%',
    height: '100%'
  }
})
