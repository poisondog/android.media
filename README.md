# Installation process

- install android sdk
- go into android sdk path
- connect your android device to computer
- Your phone must be in the same area network as your computer
- remember your phone ip

```bash
platform-tools/adb tcpip 5555
```

```bash
docker run -ti --rm -v /tmp:/tmp androidsdk/android-28 bash
platform-tools/adb connect <phone-ip>:5555
cd /tmp
git clone https://github.com/poisondog/android.media.git
cd android.media/app
echo 'sdk.dir=/opt/android-sdk-linux' >> local.properties
./gradlew clean iDe
```
