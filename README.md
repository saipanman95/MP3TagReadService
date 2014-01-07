MP3TagReadService
=================

A simple web service for getting a json array of mp3 tag details from a collection of mp3's by passing the local file location. Project uses Spring, EhCache for controlling how often mp3 files are scanned and JAudioTagger library for reading mp3 files. Jetty is used as a proof of concept for standing up the web-service on the fly without using a application container.
