# AndroidJsonApi

## What's this?

Java implementation of the [JsonApi](http://jsonapi.org/) specification with focus on Android and performance. The main goal of this library is to avoid reflection which can be really slow on Android devices, we try to achieve it with code generation technics and annotation processing.

## Download

Gradle:

```groovy
compile 'br.com.bankfacil:androidjsonapi:0.0.1'
```

AndroidJsonApi requires at minimum Java 7. If compiling from source code Java 8 will be necessary because we make use of the Retrolambda tool. 

## How to use

 * [JsonApi response example](docs/JsonApiSample.md)
 * [Creating your models](docs/Models.md)
 * [Parsing from JSON](docs/Parsing.md)
 * [Serializing to JSON](docs/Serializing.md)
 * [Using pre-built converters](docs/Converters.md)

## Proguard

Like all libraries that generate dynamic code, Proguard might think some classes are unused and remove them. To prevent this, the following lines can be added to your proguard config file.

```
  -keep class br.com.bankfacil.androidjsonapi.** { *; }
  -keep @jsonapi.JsonApiResource class *
  -keep @jsonapi.JsonApiRelationship class *
  -keep class JsonApi_** { *; }
```

## Contributors

Abraao Lima - abraaorl@gmail.com

## License

MIT License: http://bankfacil.mit-license.org

## Powered by

Bankfacil: http://www.bankfacil.com.br

Join our team! Read about our [development culture](https://www.bankfacil.com.br/dev) and check our [open positions](https://bankfacil.recruiterbox.com/)
