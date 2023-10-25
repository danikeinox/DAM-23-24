# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    while True:
        if "y" == input("Do you want to continue? (y/n)"):
            print("Continuing...")
            break
        elif "y" == input("Do you want to exit? (y/n)"):
            break
        else:
            print("Try again")


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('Mundo')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
