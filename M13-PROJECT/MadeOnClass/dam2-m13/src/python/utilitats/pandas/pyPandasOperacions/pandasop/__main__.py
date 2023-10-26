#! /usr/bin/env python3

import sys

if __name__ == "__main__":
    # Comprovar si la versió de Python és correcta
    python_version = sys.version.split()[0]

    if sys.version_info < (3, 6):
        print("PandasOp requires Python 3.11+\nYou are using Python %s, which is not supported by PandasOp" % (
            python_version))
        sys.exit(1)

    import main
    main.run()
