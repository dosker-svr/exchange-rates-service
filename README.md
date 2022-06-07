### Сервис получения gif в зависимости от разницы курса валюты

Сервис, который обращается к сервису курсов валют, и отображает gif:
  * если курс по отношению к USD за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich
  * если ниже - отсюда https://giphy.com/search/broke

Используемые API:
  * REST API курсов валют - https://docs.openexchangerates.org/
  * REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide

Для сборки сервиса:
```
./gradlew clean build
```

Для запуска сервиса в Docker-контейнере:
```
docker build -t ex_app .
docker run -p 8080:8080 -d ex_app
```