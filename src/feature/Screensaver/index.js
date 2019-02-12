// @flow
import React from 'react'
import type Node from 'react'
import { StatusBar, StyleSheet, View } from 'react-native'
import { Immersive } from 'react-native-immersive'
import { Constants } from 'expo'

import ClockWidget from './widget/ClockWidget'

export default class Screensaver extends React.Component<void> {

  componentDidMount (): void {
    StatusBar.setHidden(true)
    this.enterImmersiveMode()
    Immersive.addImmersiveListener(this.enterImmersiveMode)
  }

  componentWillUnmount (): void {
    Immersive.removeImmersiveListener(this.enterImmersiveMode)
  }

  enterImmersiveMode = () => {
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
    position: 'absolute',
    top: 0,
    bottom: 0,
    left: 0,
    right: 0
  },
  screensaverContainer: {
    position: 'relative',
    top: -(Constants.statusBarHeight)
  }
})
