[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)
[![DevOps By Rultor.com](https://www.rultor.com/b/baudoliver7/ool-survey)](https://www.rultor.com/p/baudoliver7/ool-survey)
[![We recommend IntelliJ IDEA](https://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)

[![PDD status](https://www.0pdd.com/svg?name=baudoliver7/ool-survey)](https://www.0pdd.com/p?name=baudoliver7/ool-survey)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/baudoliver7/ool-survey/blob/main/LICENSE.txt)

[![Java version supported ](https://img.shields.io/badge/java-v8%2B-blue)](http://java.oracle.com)
[![Javadoc](https://www.javadoc.io/badge/com.baudoliver7/ool-survey.svg)](https://www.javadoc.io/doc/com.baudoliver7/ool-survey)
[![Maven Central](https://img.shields.io/maven-central/v/com.baudoliver7/ool-survey.svg)](https://maven-badges.herokuapp.com/maven-central/com.baudoliver7/ool-survey)

[![codecov](https://codecov.io/gh/baudoliver7/ool-survey/branch/master/graph/badge.svg?token=AlLqLoNAeF)](https://codecov.io/gh/baudoliver7/ool-survey)
[![Hits-of-Code](https://hitsofcode.com/github/baudoliver7/ool-survey)](https://hitsofcode.com/github/baudoliver7/ool-survey/view)

Project architect: [baudoliver7](https://github.com/baudoliver7)

## What does it do ?
It helps to select OO languages for a survey.

## Pre-requisites
* JDK 1.8 or +
* Maven 3.1.0 or +

## How does it work ?
You can run it by these commands :

### From Maven
``` cmd
mvn clean pre-integration-test -Pstart-app
```

### From JAR file
``` cmd
java -Dfile.encoding=utf-8 -cp ool-survey-X.X.X.jar com.ool.survey.Main
``` 

## How to contribute
Fork repository, make changes, send us a pull request. We will review
your changes and apply them to the `master` branch shortly, provided
they don't violate our quality standards. To avoid frustration, before
sending us your pull request please run full Maven build:

> mvn clean install -Pqulice

Keep in mind that JDK 1.8 and Maven 3.1.0 are the lowest versions you may use.

## Got questions ?

If you have questions or general suggestions, don't hesitate to submit
a new [Github issue](https://github.com/baudoliver7/ool-survey/issues/new).