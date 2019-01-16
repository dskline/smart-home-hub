#!/bin/bash

./gradlew ${1:-installDevMinSdkDevKernelDebug} --stacktrace && adb shell am start -n tech.spencerkline.home/host.exp.exponent.MainActivity
