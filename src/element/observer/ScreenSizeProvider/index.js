// @flow
import React from 'react'
import type Node from 'react'
import { Dimensions } from 'react-native'

import type { ScreenSizeContext } from './types'

const getDimensions = (): ScreenSizeContext => {
  const screenDimensions = Dimensions.get('screen')
  return {
    width: screenDimensions.width,
    height: screenDimensions.height
  }
}
const Context = React.createContext(getDimensions())

type Props = {
  children: Node
}
export default class ScreenSizeProvider extends React.Component<Props, ScreenSizeContext> {

  constructor (props: Props) {
    super(props)
    this.state = getDimensions()
  }

  componentDidMount (): void {
    Dimensions.addEventListener('change', () => {
      this.setState(getDimensions())
    })
  }

  componentWillUnmount (): void {
    Dimensions.removeEventListener('change')
  }

  render () {
    return (
      <Context.Provider
        value={{
          width: this.state.width,
          height: this.state.height
        }}
      >
        {this.props.children}
      </Context.Provider>
    )
  }
}
const ScreenSizeConsumer = Context.Consumer

export { ScreenSizeConsumer }
