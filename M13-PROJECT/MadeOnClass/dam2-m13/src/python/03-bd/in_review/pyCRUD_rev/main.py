import SQLHelper


def run_with_products():
    print(f"Llista inicial:".center(60, '-'))
    print(SQLHelper.get_all('tbl_productes'))
    rowid = SQLHelper.insert('tbl_productes', 'nom, preu, existencies', ('Monitor LG', 255.99, 10))
    print(f"L'últim id inserit és: {rowid}. Llista actualitzada".center(60, '-'))
    print(SQLHelper.get_all('tbl_productes'))
    dades = [
        ('Monitor ACER', 100.99, 30),
        ('Monitor ASUS', 200.99, 20),
        ('Monitor DELL', 300.99, 10),
    ]
    rows = SQLHelper.insert('tbl_productes', 'nom, preu, existencies', dades, True)
    print(f"{rows} registres inserits. Llista actualitzada".center(60, '-'))
    print(SQLHelper.get_all('tbl_productes'))
    print(f'Modifiquem el registre {rowid}')
    SQLHelper.update('tbl_productes', 'preu', 1000.10, primary_key_value=rowid)
    print(SQLHelper.get_all('tbl_productes'))
    dele = SQLHelper.delete('tbl_productes', 'id', rowid)
    print(f'S\'han eliminat {dele} registres')
    print(SQLHelper.get_all('tbl_productes'))
    dades_update = [
        ('Monitor ACERxXx', 100.99, 30, 451),
        ('Monitor ASUSxXx', 200.99, 20, 452),
        ('Monitor DELLxXx', 300.99, 10, 453),
    ]
    updated_rows = SQLHelper.update_many('tbl_productes', ('nom', 'preu', 'existencies'), dades_update)
    print(f'S\'han modificat {updated_rows} registres')
    print(SQLHelper.get_all('tbl_productes'))


def run_with_color():
    print(f"Llista inicial:".center(60, '-'))
    print(SQLHelper.get_all('tbl_color'))
    rowid = SQLHelper.insert('tbl_color', 'color', ('GRANA',))
    print(f"L'últim id inserit és: {rowid}. Llista actualitzada".center(60, '-'))
    print(SQLHelper.get_all('tbl_color'))
    print(f'Modifiquem el registre {rowid}')
    SQLHelper.update('tbl_color', 'color', 'GROC', primary_key_value=rowid)
    print(SQLHelper.get_all('tbl_color'))
    dele = SQLHelper.delete('tbl_color', 'id', rowid)
    print(f'S\'han eliminat {dele} registres')
    print(SQLHelper.get_all('tbl_color'))


def run_main():
    # run_with_color()
    run_with_products()


if __name__ == '__main__':
    run_main()
