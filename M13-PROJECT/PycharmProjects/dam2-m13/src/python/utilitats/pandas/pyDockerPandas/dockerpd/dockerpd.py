from db.db_helper import get_dataframe

module_name = "dockerpd: Exemple d'integració entre timescale, pandas i grafana"
__version__ = "0.0.1"


def main():
    sql = 'SELECT time, humidity, temperature from tbl_meteo ORDER BY time DESC LIMIT 100;'

    df_all = get_dataframe(sql)
    print(f'Dataframe complet\n{df_all}')

    if __name__ == "__main__":
        main()

# print(f'Els 5 primers elements <HEAD>:\n{df_all.head()}')
#
# columns = helper.get_columns(df_all)
# print(f"Columnes del Dataframe\n{columns}")
#

# valor = helper.filter_by_column(df=df_all, column='humidity', value=17.0, operation='gt')

# print(f"El valor que cerques existeix\n : {valor}")  # índex: 49, temperature
# print(f"El valor que cerques existeix? : {helper.search_column(df_all, '24.385009')}")  # índex: 49, temperature

# time = helper.divide_dataframe_by_column(df=df_all, column='time')
# temp = helper.divide_dataframe_by_column(df=df_all, column='temperature')
# humi = helper.divide_dataframe_by_column(df=df_all, column='humidity')
# print(f"Columna time del Dataframe\n{time}")
# print(f"Columna temperature del Dataframe\n{temp}")
# print(f"Columna humidity del Dataframe\n{humi}")
#
# mitjana_temp = helper.mean(df_all, 'temperature')
# mitjana_humi = helper.mean(df_all, 'humidity')
# print(f'La mitjana de temperatura és {mitjana_temp}')
# print(f'La mitjana d\'humitat és {mitjana_humi}')

# print("Proves d' ordenació")
# by_humi = helper.sort_by_value(df_all, 'temperature', ascending=False)
# by_humi_temp_asc = helper.sort_by_value(df=df_all, expression=['temperature', 'time'], ascending=False)
# print(by_humi)
# print(by_humi_temp_asc)

# YY MM DD
# start = pd.Timestamp('2023-11-28', ).tz_localize('Europe/Madrid')
# end = pd.Timestamp('2023-11-29', ).tz_localize('Europe/Madrid')
# by_date = helper.filter_by_date(df=df_all, data=start, operation='lt', time_column='time')
# between_dates = helper.filter_between_dates(df=df_all, data_inici=start, data_final=end, time_column='time')
# print(by_date)
# print(between_dates)
