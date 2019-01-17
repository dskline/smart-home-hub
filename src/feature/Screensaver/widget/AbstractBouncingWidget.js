// @flow
import React from 'react'

type Props = {
  containerHeight: number,
  containerWidth: number,
  widgetHeight: number,
  widgetWidth: number
}
type State = {
  dirHorizontal: 1 | -1,
  dirVertical: 1 | -1,
  left: number,
  leftMax: number,
  top: number,
  topMax: number
}
const defaultState = {
  dirHorizontal: 1,
  dirVertical: 1,
  left: 0,
  top: 0
}
export default class AbstractBouncingWidget extends React.Component<Props, State> {

  constructor (props: Props) {
    super(props)
    this.state = {
      leftMax: Math.floor(props.containerWidth - props.widgetWidth),
      topMax: Math.floor(props.containerHeight - props.widgetHeight),
      ...defaultState
    }
  }

  static getDerivedStateFromProps (nextProps: Props, prevState: State) {
    const leftMax = Math.floor(nextProps.containerWidth - nextProps.widgetWidth)
    const topMax = Math.floor(nextProps.containerHeight - nextProps.widgetHeight)

    if (prevState.left > leftMax || prevState.top > topMax) {
      return {
        leftMax: leftMax,
        topMax: topMax,
        ...defaultState
      }
    }
    return null
  }

  componentDidMount (): void {
    setInterval(() => {
      this.updatePosition()
    }, 500)
  }

  updatePosition = () => {
    let nextPosition = Object.assign({}, this.state)

    nextPosition.left += nextPosition.dirHorizontal
    nextPosition.top += nextPosition.dirVertical

    if (nextPosition.left === 0 || nextPosition.left === this.state.leftMax) {
      nextPosition.dirHorizontal *= -1
    }
    if (nextPosition.top === 0 || nextPosition.top === this.state.topMax) {
      nextPosition.dirVertical *= -1
    }
    this.setState(nextPosition)
  }
}
