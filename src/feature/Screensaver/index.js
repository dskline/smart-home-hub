// @flow
import React from 'react'
import type Node from 'react'
import { StatusBar, StyleSheet, View } from 'react-native'
import { Immersive } from 'react-native-immersive'

import ClockWidget from './widget/ClockWidget'

export default class Screensaver extends React.Component<void> {

  componentDidMount (): void {
    StatusBar.setHidden(true)
    Immersive.on()
  }

  render (): Node {
    return (
      <View style={styles.window}>
        <View style={styles.screensaverContainer}>
          <ClockWidget />
        </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  window: {
    backgroundColor: '#000',
    width: '100%',
    height: '100%',
    position: 'absolute',
    top: 0,
    left: 0
  },
  screensaverContainer: {
    position: 'relative',
    top: -40
  }
})
