# qwerty-app-reagent
An app based on [om-next-cross-platform-template](https://github.com/artemyarulin/om-next-cross-platform-template), made to work with reagent 0.5.

## Changes
* Replaced om-next with Reagent 0.5
* Excluded cjjsjs/react (required for Reagent to work under react-native)
* Fixed dummy cljsjs namespaces (required for Reagent to work when react deps are excluded)
* Bumped android build-tools version to 23.0.2
* Web version currently NOT WORKING because cjjsjs/react dep is excluded

## Development

- browser: `lein repl` then open http://localhost:3449
- mobile: `lein cljsbuild once repl && lein repl` then run your React Native app

## Release

- Browser - `lein cljsbuild once release`
- Mobile - `lein with-profile mobile cljsbuild once release`
