# Cryptography Algorithms in Java

[![Build](https://github.com/AbdelrahmanGamal1998/cryptography-algorithms-java/actions/workflows/build.yml/badge.svg)](https://github.com/AbdelrahmanGamal1998/cryptography-algorithms-java/actions/workflows/build.yml)

Three classic ciphers implemented from scratch in Java, without crypto libraries, for a university
information security course (2021): **DES**, **RSA** and the **Playfair cipher**. Each one has a small
console demo and unit tests that check it against known answers.

| Package     | What it implements                                                                                  | Checked against                                       |
| ----------- | --------------------------------------------------------------------------------------------------- | ----------------------------------------------------- |
| `des`       | DES encryption and decryption: key schedule (16 sub-keys), initial and final permutation, S-boxes   | The classic textbook vector: key `133457799BBCDFF1`, plaintext `0123456789ABCDEF` gives `85E813540F0AB405`, and decryption gives the plaintext back |
| `playfair`  | Playfair cipher: 5x5 key table, digraph encoding and decoding, `X` padding and `J` mapped to `I`    | The worked example from Wikipedia: key `PLAYFAIR EXAMPLE`, message `HIDETHEGOLDINTHETREESTUMP` gives `BMODZBXDNABEKUDMUIXMMOUVIF` |
| `rsa`       | Textbook RSA on small numbers: it picks `e` and `d` from two primes you enter and encrypts a word or a number | A round trip with `p=5, q=11`: 4 encrypts to 9 and decrypts back to 4 |

## Run it

You need JDK 17 or newer and Maven.

```bash
git clone https://github.com/AbdelrahmanGamal1998/cryptography-algorithms-java.git
cd cryptography-algorithms-java
mvn test                                # runs the unit tests
mvn -q compile
java -cp target/classes des.Main        # DES demo: enter a 16 hex digit key and message
java -cp target/classes playfair.Playfair
java -cp target/classes rsa.RSA
```

## Notes

- This is for learning only. Do not use it to protect real data: DES is obsolete, and the RSA here uses `int`
  arithmetic with tiny primes, so it only works for small messages.
- Changes made when the code was cleaned up: one Maven project with a package per algorithm, the Playfair
  class renamed from `playfair` to `Playfair`, a bug fixed in `RSA.isPrime` (it reported composite numbers as
  prime), unit tests and CI. DES and Playfair matched the known answers without any change.
- The original repositories also contained scan reports from a group assignment. They are not included here
  because they carry other students' names and ID numbers.

## License

[MIT](LICENSE)
