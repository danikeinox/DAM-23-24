from classes.comandament_lg import ComandamentLG
from classes.comandament_sony import ComandamentSony


def run_main():
    c_lg = ComandamentLG()
    c_lg.baixa_volum()

    c_sony = ComandamentSony()
    c_sony.baixa_volum()


if __name__ == '__main__':
    run_main()
