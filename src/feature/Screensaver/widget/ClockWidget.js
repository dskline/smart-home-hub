// @flow
import React from 'react'
import type Node from 'react'
import { StyleSheet, Text, View } from 'react-native'

import AbstractBouncingWidget from './AbstractBouncingWidget'
import ScreenSizeProvider, { ScreenSizeConsumer } from 'src/element/observer/ScreenSizeProvider'

const getCurrentTime = () => {
  const date = new Date()
  return `${date.getHours() % 12 || 12}:${('0' + date.getMinutes()).slice(-2)}`
}

export default class ClockWidget extends React.Component {
  render (): Node {
    return (
      <ScreenSizeProvider>
        <ScreenSizeConsumer>
          {({ width, height }) => {
            const widgetHeight = Math.min(width, height) / 5
            return (
              <BouncingClockWidget
                containerWidth={width}
                containerHeight={height - 10}
                widgetWidth={widgetHeight * 3}
                widgetHeight={widgetHeight}
              />
            )
          }}
        </ScreenSizeConsumer>
      </ScreenSizeProvider>
    )
  }
}

class BouncingClockWidget extends AbstractBouncingWidget {

  render (): Node {
    return (
      <View style={{
        top: this.state.top,
        left: this.state.left,
        ...styles.widgetContainer
      }}>
        <Text style={{
          color: '#fff',
          fontSize: this.props.widgetHeight,
          fontFamily: 'sans-serif-light',
          fontWeight: 'bold'
        }}>
          { getCurrentTime() }
        </Text>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  widgetContainer: {
    flex: 1,
    position: 'absolute',
    alignItems: 'center'
  }
})
