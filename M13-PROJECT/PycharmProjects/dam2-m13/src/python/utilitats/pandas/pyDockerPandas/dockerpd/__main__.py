#! /usr/bin/env python3

import sys

if __name__ == "__main__":
    # Comprovar si la versió de Python és correcta
    python_version = sys.version.split()[0]

    if sys.version_info < (3, 6):
        print("dockerpd requires Python 3.11+\nYou are using Python %s, which is not supported by dockerpd" % (
            python_version))
        sys.exit(1)

    import dockerpd
    dockerpd.main()
