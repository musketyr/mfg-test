# Mfg Test

This is a Micronaut AWS Lambda Function generated using [Micronaut Function Template][mfgt]

<!-- TODO: add your own description -->

[mfgt]: https://github.com/agorapulse/lazybones-templates#micronaut-function-groovy

## Getting Around

<!-- Feel free to delete this section when you get familiar with the project -->

The following files are waiting for you implementation:

 * [MfgTestService](src/main/groovy/com/tmp/mfg/test/MfgTestService.groovy) - The main service
 * [MfgTestServiceSpec](src/test/groovy/com/tmp/mfg/test/MfgTestServiceSpec.groovy) - The main service's test
 * [MfgTestRequest](src/main/groovy/com/tmp/mfg/test/MfgTestRequest.groovy) - Input event
 * [MfgTestResponse](src/main/groovy/com/tmp/mfg/test/MfgTestResponse.groovy) - Output event

The following files are infrastructure ones and should not be changed:
 * [Application](src/main/groovy/com/tmp/mfg/test/Application.java) - Local server launcher
 * [MfgTestHandler](src/main/groovy/com/tmp/mfg/test/MfgTestHandler.groovy) - AWS Lambda handler
 * [MfgTestHandlerSpec](src/test/groovy/com/tmp/mfg/test/MfgTestHandlerSpec.groovy) - AWS Lambda handler sanity test

There are two configuration files:
 * [application.yml](src/main/resources/application.yml) - Main configuration file for production and local server
 * [application-dev.yml](src/main/resources/application-dev.yml) - Main configuration file for local server only


You need to [create new GitHub repository](https://github.com/new) called `musketyr/mfg-test` if you haven't done so.

You need to configure [GitHub Secrets](https://github.com/musketyr/mfg-test/settings/secrets) if you want to enable automated deployments:
 * `STAGING_AWS_ACCESS_KEY_ID` - AWS key ID for the staging environment
 * `STAGING_AWS_SECRET_ACCESS_KEY` - AWS secret key for the staging environment
 * `PRODUCTION_AWS_ACCESS_KEY_ID` - AWS key ID for the production environment
 * `PRODUCTION_AWS_SECRET_ACCESS_KEY` - AWS secret key for the production environment


Push this project to GitHub:
```
git init
git add -A
git commit -m "Initial commit"
git remote add origin git@github.com:musketyr/mfg-test.git
git push -u origin master
```

## Local Execution

The function can be run using the embedded HTTP server at `http://localhost:8080`:

```
./gradlew run
```

Then you can execute the function using [IntelliJ HTTP Request File](mfg-test.http) or cURL:

```
curl --header "Content-Type: application/json" --request POST --data '{ }' http://localhost:8080/mfg-test
```

The port can be changed by setting the `micronaut.server.port` property in the local [configuration file](src/main/resources/application-dev.yml).

## Manual Deployment

You need to setup you AWS credentials before deploying this function. There are two ways how to achieve this:

Either ensure you have set up your credentials in `~/.aws/credentials` file:
```
[beta]
aws_access_key_id = beta access key ID
aws_secret_access_key = beta secret access key
region = eu-west-1
```

Or by using environmental variables by running following commands in your terminal:

```
export AWS_ACCESS_KEY_ID=beta access key ID
export AWS_SECRET_ACCESS_KEY=beta secret access key
export AWS_DEFAULT_REGION=eu-west-1
```

Then you can deploy the function by running the following command:

```
./gradlew deploy
```

After deployment you should be able to open the following links:

 * [Function][deployed]
 * [Logs][logs]

[deployed]: https://eu-west-1.console.aws.amazon.com/lambda/home?region=eu-west-1#/functions/MfgTest?tab=configuration
[logs]: https://eu-west-1.console.aws.amazon.com/cloudwatch/home?region=eu-west-1#logStream:group=/aws/lambda/MfgTest;streamFilter=typeLogStreamPrefix


## Continuous Integration and Delivery

This function has enabled continuous integration and delivery using GitHub Actions:

 * [Check](https://github.com/musketyr/mfg-test/actions?query=workflow%3ACheck) - After each commit to any branch or any PR request opened the `./gradlew check` command is run (see [gradle.yml](.github/workflows/gradle.yml)))
 * [Gradle RC Watchdog](https://github.com/musketyr/mfg-test/actions?query=workflow%3AGradle+RC+Watchdog) - Once month `master` branch is tested against the latest RC version of Gradle``./gradlew check` command is run (see [gradle-versions-watchdog.yml](.github/workflows/gradle-versions-watchdog.yml))
 * [Release to Staging](https://github.com/musketyr/mfg-test/actions?query=workflow%3ARelease+to+Staging) - Every commit into `master` branch runs `./gradlew deploy` using `STAGING_AWS_ACCESS_KEY_ID` and  `STAGING_AWS_SECRET_ACCESS_KEY` secrets (see [staging.yml.gtpl](.github/workflows/staging.yml))
 * [Release to Production](https://github.com/musketyr/mfg-test/actions?query=workflow%3ARelease+to+Production) - Every release (tag)  runs `./gradlew deploy` using `PRODUCTION_AWS_ACCESS_KEY_ID` and  `PRODUCTION_AWS_SECRET_ACCESS_KEY` secrets  (see [release.yml](.github/workflows/release.yml))




