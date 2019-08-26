

```python
import numpy as np
import scipy as sp
import pandas as pd
```


```python
#Load the data file into data frame
```


```python
from pandas.io.parsers import read_csv
```


```python
df=read_csv("WHO_first9cols.csv")
```


```python
print("Dataframe:\n",df) #파일읽기 
print("\n")
#df 하면 더 깔끔 .head() 잘나오는지만 볼수있음
```

    Dataframe:
                           Country  CountryID  Continent  \
    0                 Afghanistan          1          1   
    1                     Albania          2          2   
    2                     Algeria          3          3   
    3                     Andorra          4          2   
    4                      Angola          5          3   
    5         Antigua and Barbuda          6          4   
    6                   Argentina          7          5   
    7                     Armenia          8          2   
    8                   Australia          9          6   
    9                     Austria         10          2   
    10                 Azerbaijan         11          2   
    11                    Bahamas         12          4   
    12                    Bahrain         13          1   
    13                 Bangladesh         14          7   
    14                   Barbados         15          4   
    15                    Belarus         16          2   
    16                    Belgium         17          2   
    17                     Belize         18          5   
    18                      Benin         19          3   
    19                    Bermuda         20          4   
    20                     Bhutan         21          7   
    21                    Bolivia         22          5   
    22     Bosnia and Herzegovina         23          2   
    23                   Botswana         24          3   
    24                     Brazil         25          5   
    25          Brunei Darussalam         26          6   
    26                   Bulgaria         27          2   
    27               Burkina Faso         28          3   
    28                    Burundi         29          3   
    29                   Cambodia         30          7   
    ..                        ...        ...        ...   
    172                 Swaziland        173          3   
    173                    Sweden        174          2   
    174               Switzerland        175          2   
    175                     Syria        176          1   
    176                    Taiwan        177          6   
    177                Tajikistan        178          2   
    178                  Tanzania        179          3   
    179                  Thailand        180          6   
    180               Timor-Leste        181          6   
    181                      Togo        182          3   
    182                     Tonga        183          6   
    183       Trinidad and Tobago        184          5   
    184                   Tunisia        185          1   
    185                    Turkey        186          2   
    186              Turkmenistan        187          2   
    187                    Tuvalu        188          6   
    188                    Uganda        189          3   
    189                   Ukraine        190          2   
    190      United Arab Emirates        191          1   
    191            United Kingdom        192          2   
    192  United States of America        193          4   
    193                   Uruguay        194          5   
    194                Uzbekistan        195          2   
    195                   Vanuatu        196          6   
    196                 Venezuela        197          5   
    197                   Vietnam        198          6   
    198        West Bank and Gaza        199          1   
    199                     Yemen        200          1   
    200                    Zambia        201          3   
    201                  Zimbabwe        202          3   
    
         Adolescent fertility rate (%)  Adult literacy rate (%)  \
    0                            151.0                     28.0   
    1                             27.0                     98.7   
    2                              6.0                     69.9   
    3                              NaN                      NaN   
    4                            146.0                     67.4   
    5                              NaN                      NaN   
    6                             62.0                     97.2   
    7                             30.0                     99.4   
    8                             16.0                      NaN   
    9                             14.0                      NaN   
    10                            31.0                     98.8   
    11                            46.0                      NaN   
    12                            14.0                     86.5   
    13                           135.0                     47.5   
    14                            51.0                      NaN   
    15                            22.0                     99.6   
    16                             5.0                      NaN   
    17                            90.0                     70.3   
    18                           108.0                     34.7   
    19                             NaN                      NaN   
    20                            62.0                      NaN   
    21                            97.0                     86.7   
    22                            25.0                     96.7   
    23                            51.0                     81.2   
    24                            71.0                     88.6   
    25                            31.0                     92.7   
    26                            40.0                     98.2   
    27                           131.0                     23.6   
    28                            30.0                     59.3   
    29                            52.0                     73.6   
    ..                             ...                      ...   
    172                           73.0                     79.6   
    173                            7.0                      NaN   
    174                            5.0                      NaN   
    175                           58.0                     80.8   
    176                            NaN                      NaN   
    177                           57.0                     99.5   
    178                          139.0                     69.4   
    179                           70.0                     92.6   
    180                           49.0                      NaN   
    181                           89.0                     53.2   
    182                           17.0                     98.9   
    183                           35.0                     98.5   
    184                            8.0                     74.3   
    185                           51.0                     87.4   
    186                           29.0                     98.8   
    187                            NaN                      NaN   
    188                          159.0                     68.1   
    189                           29.0                     99.4   
    190                           37.0                     88.5   
    191                           27.0                      NaN   
    192                           43.0                      NaN   
    193                           64.0                     96.8   
    194                           40.0                      NaN   
    195                           92.0                     75.5   
    196                           81.0                     93.0   
    197                           25.0                     90.3   
    198                            NaN                      NaN   
    199                           83.0                     54.1   
    200                          161.0                     68.0   
    201                          101.0                     89.5   
    
         Gross national income per capita (PPP international $)  \
    0                                                  NaN        
    1                                               6000.0        
    2                                               5940.0        
    3                                                  NaN        
    4                                               3890.0        
    5                                              15130.0        
    6                                              11670.0        
    7                                               4950.0        
    8                                              33940.0        
    9                                              36040.0        
    10                                              5430.0        
    11                                                 NaN        
    12                                             34310.0        
    13                                              1230.0        
    14                                             15150.0        
    15                                              9700.0        
    16                                             33860.0        
    17                                              7080.0        
    18                                              1250.0        
    19                                                 NaN        
    20                                              4000.0        
    21                                              3810.0        
    22                                              6780.0        
    23                                             11730.0        
    24                                              8700.0        
    25                                             49900.0        
    26                                             10270.0        
    27                                              1130.0        
    28                                               320.0        
    29                                              1550.0        
    ..                                                 ...        
    172                                             4700.0        
    173                                            34310.0        
    174                                            40840.0        
    175                                             4110.0        
    176                                                NaN        
    177                                             1560.0        
    178                                              980.0        
    179                                             7440.0        
    180                                             5100.0        
    181                                              770.0        
    182                                             5470.0        
    183                                            16800.0        
    184                                             6490.0        
    185                                             8410.0        
    186                                             3990.0        
    187                                                NaN        
    188                                              880.0        
    189                                             6110.0        
    190                                            31190.0        
    191                                            33650.0        
    192                                            44070.0        
    193                                             9940.0        
    194                                             2190.0        
    195                                             3480.0        
    196                                            10970.0        
    197                                             2310.0        
    198                                                NaN        
    199                                             2090.0        
    200                                             1140.0        
    201                                                NaN        
    
         Net primary school enrolment ratio female (%)  \
    0                                              NaN   
    1                                             93.0   
    2                                             94.0   
    3                                             83.0   
    4                                             49.0   
    5                                              NaN   
    6                                             98.0   
    7                                             84.0   
    8                                             97.0   
    9                                             98.0   
    10                                            83.0   
    11                                            89.0   
    12                                            98.0   
    13                                            90.0   
    14                                            96.0   
    15                                            88.0   
    16                                            97.0   
    17                                            97.0   
    18                                            73.0   
    19                                             NaN   
    20                                            79.0   
    21                                            95.0   
    22                                             NaN   
    23                                            85.0   
    24                                            95.0   
    25                                            94.0   
    26                                            92.0   
    27                                            42.0   
    28                                            73.0   
    29                                            89.0   
    ..                                             ...   
    172                                           79.0   
    173                                           95.0   
    174                                           89.0   
    175                                           92.0   
    176                                            NaN   
    177                                           95.0   
    178                                           97.0   
    179                                           94.0   
    180                                           67.0   
    181                                           75.0   
    182                                           94.0   
    183                                           85.0   
    184                                           97.0   
    185                                           89.0   
    186                                            NaN   
    187                                            NaN   
    188                                            NaN   
    189                                           90.0   
    190                                           88.0   
    191                                           99.0   
    192                                           93.0   
    193                                          100.0   
    194                                           78.0   
    195                                           86.0   
    196                                           91.0   
    197                                           91.0   
    198                                            NaN   
    199                                           65.0   
    200                                           94.0   
    201                                           88.0   
    
         Net primary school enrolment ratio male (%)  \
    0                                            NaN   
    1                                           94.0   
    2                                           96.0   
    3                                           83.0   
    4                                           51.0   
    5                                            NaN   
    6                                           99.0   
    7                                           80.0   
    8                                           96.0   
    9                                           97.0   
    10                                          86.0   
    11                                          87.0   
    12                                          98.0   
    13                                          87.0   
    14                                          97.0   
    15                                          90.0   
    16                                          97.0   
    17                                          97.0   
    18                                          87.0   
    19                                           NaN   
    20                                          79.0   
    21                                          94.0   
    22                                           NaN   
    23                                          83.0   
    24                                          93.0   
    25                                          94.0   
    26                                          93.0   
    27                                          52.0   
    28                                          76.0   
    29                                          91.0   
    ..                                           ...   
    172                                         78.0   
    173                                         95.0   
    174                                         89.0   
    175                                         97.0   
    176                                          NaN   
    177                                         99.0   
    178                                         98.0   
    179                                         94.0   
    180                                         70.0   
    181                                         86.0   
    182                                         97.0   
    183                                         85.0   
    184                                         96.0   
    185                                         93.0   
    186                                          NaN   
    187                                          NaN   
    188                                          NaN   
    189                                         90.0   
    190                                         88.0   
    191                                         98.0   
    192                                         91.0   
    193                                        100.0   
    194                                         79.0   
    195                                         88.0   
    196                                         91.0   
    197                                         96.0   
    198                                          NaN   
    199                                         85.0   
    200                                         90.0   
    201                                         87.0   
    
         Population (in thousands) total  
    0                            26088.0  
    1                             3172.0  
    2                            33351.0  
    3                               74.0  
    4                            16557.0  
    5                               84.0  
    6                            39134.0  
    7                             3010.0  
    8                            20530.0  
    9                             8327.0  
    10                            8406.0  
    11                             327.0  
    12                             739.0  
    13                          155991.0  
    14                             293.0  
    15                            9742.0  
    16                           10430.0  
    17                             282.0  
    18                            8760.0  
    19                               NaN  
    20                             649.0  
    21                            9354.0  
    22                            3926.0  
    23                            1858.0  
    24                          189323.0  
    25                             382.0  
    26                            7693.0  
    27                           14359.0  
    28                            8173.0  
    29                           14197.0  
    ..                               ...  
    172                           1134.0  
    173                           9078.0  
    174                           7455.0  
    175                          19408.0  
    176                              NaN  
    177                           6640.0  
    178                          39459.0  
    179                          63444.0  
    180                           1114.0  
    181                           6410.0  
    182                            100.0  
    183                           1328.0  
    184                          10215.0  
    185                          73922.0  
    186                           4899.0  
    187                             10.0  
    188                          29899.0  
    189                          46557.0  
    190                           4248.0  
    191                          60512.0  
    192                         302841.0  
    193                           3331.0  
    194                          26981.0  
    195                            221.0  
    196                          27191.0  
    197                          86206.0  
    198                              NaN  
    199                          21732.0  
    200                          11696.0  
    201                          13228.0  
    
    [202 rows x 9 columns]
    
    
    




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Country</th>
      <th>CountryID</th>
      <th>Continent</th>
      <th>Adolescent fertility rate (%)</th>
      <th>Adult literacy rate (%)</th>
      <th>Gross national income per capita (PPP international $)</th>
      <th>Net primary school enrolment ratio female (%)</th>
      <th>Net primary school enrolment ratio male (%)</th>
      <th>Population (in thousands) total</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>Afghanistan</td>
      <td>1</td>
      <td>1</td>
      <td>151.0</td>
      <td>28.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>26088.0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Albania</td>
      <td>2</td>
      <td>2</td>
      <td>27.0</td>
      <td>98.7</td>
      <td>6000.0</td>
      <td>93.0</td>
      <td>94.0</td>
      <td>3172.0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Algeria</td>
      <td>3</td>
      <td>3</td>
      <td>6.0</td>
      <td>69.9</td>
      <td>5940.0</td>
      <td>94.0</td>
      <td>96.0</td>
      <td>33351.0</td>
    </tr>
    <tr>
      <th>3</th>
      <td>Andorra</td>
      <td>4</td>
      <td>2</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>83.0</td>
      <td>83.0</td>
      <td>74.0</td>
    </tr>
    <tr>
      <th>4</th>
      <td>Angola</td>
      <td>5</td>
      <td>3</td>
      <td>146.0</td>
      <td>67.4</td>
      <td>3890.0</td>
      <td>49.0</td>
      <td>51.0</td>
      <td>16557.0</td>
    </tr>
    <tr>
      <th>5</th>
      <td>Antigua and Barbuda</td>
      <td>6</td>
      <td>4</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>15130.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>84.0</td>
    </tr>
    <tr>
      <th>6</th>
      <td>Argentina</td>
      <td>7</td>
      <td>5</td>
      <td>62.0</td>
      <td>97.2</td>
      <td>11670.0</td>
      <td>98.0</td>
      <td>99.0</td>
      <td>39134.0</td>
    </tr>
    <tr>
      <th>7</th>
      <td>Armenia</td>
      <td>8</td>
      <td>2</td>
      <td>30.0</td>
      <td>99.4</td>
      <td>4950.0</td>
      <td>84.0</td>
      <td>80.0</td>
      <td>3010.0</td>
    </tr>
    <tr>
      <th>8</th>
      <td>Australia</td>
      <td>9</td>
      <td>6</td>
      <td>16.0</td>
      <td>NaN</td>
      <td>33940.0</td>
      <td>97.0</td>
      <td>96.0</td>
      <td>20530.0</td>
    </tr>
    <tr>
      <th>9</th>
      <td>Austria</td>
      <td>10</td>
      <td>2</td>
      <td>14.0</td>
      <td>NaN</td>
      <td>36040.0</td>
      <td>98.0</td>
      <td>97.0</td>
      <td>8327.0</td>
    </tr>
    <tr>
      <th>10</th>
      <td>Azerbaijan</td>
      <td>11</td>
      <td>2</td>
      <td>31.0</td>
      <td>98.8</td>
      <td>5430.0</td>
      <td>83.0</td>
      <td>86.0</td>
      <td>8406.0</td>
    </tr>
    <tr>
      <th>11</th>
      <td>Bahamas</td>
      <td>12</td>
      <td>4</td>
      <td>46.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>89.0</td>
      <td>87.0</td>
      <td>327.0</td>
    </tr>
    <tr>
      <th>12</th>
      <td>Bahrain</td>
      <td>13</td>
      <td>1</td>
      <td>14.0</td>
      <td>86.5</td>
      <td>34310.0</td>
      <td>98.0</td>
      <td>98.0</td>
      <td>739.0</td>
    </tr>
    <tr>
      <th>13</th>
      <td>Bangladesh</td>
      <td>14</td>
      <td>7</td>
      <td>135.0</td>
      <td>47.5</td>
      <td>1230.0</td>
      <td>90.0</td>
      <td>87.0</td>
      <td>155991.0</td>
    </tr>
    <tr>
      <th>14</th>
      <td>Barbados</td>
      <td>15</td>
      <td>4</td>
      <td>51.0</td>
      <td>NaN</td>
      <td>15150.0</td>
      <td>96.0</td>
      <td>97.0</td>
      <td>293.0</td>
    </tr>
    <tr>
      <th>15</th>
      <td>Belarus</td>
      <td>16</td>
      <td>2</td>
      <td>22.0</td>
      <td>99.6</td>
      <td>9700.0</td>
      <td>88.0</td>
      <td>90.0</td>
      <td>9742.0</td>
    </tr>
    <tr>
      <th>16</th>
      <td>Belgium</td>
      <td>17</td>
      <td>2</td>
      <td>5.0</td>
      <td>NaN</td>
      <td>33860.0</td>
      <td>97.0</td>
      <td>97.0</td>
      <td>10430.0</td>
    </tr>
    <tr>
      <th>17</th>
      <td>Belize</td>
      <td>18</td>
      <td>5</td>
      <td>90.0</td>
      <td>70.3</td>
      <td>7080.0</td>
      <td>97.0</td>
      <td>97.0</td>
      <td>282.0</td>
    </tr>
    <tr>
      <th>18</th>
      <td>Benin</td>
      <td>19</td>
      <td>3</td>
      <td>108.0</td>
      <td>34.7</td>
      <td>1250.0</td>
      <td>73.0</td>
      <td>87.0</td>
      <td>8760.0</td>
    </tr>
    <tr>
      <th>19</th>
      <td>Bermuda</td>
      <td>20</td>
      <td>4</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>20</th>
      <td>Bhutan</td>
      <td>21</td>
      <td>7</td>
      <td>62.0</td>
      <td>NaN</td>
      <td>4000.0</td>
      <td>79.0</td>
      <td>79.0</td>
      <td>649.0</td>
    </tr>
    <tr>
      <th>21</th>
      <td>Bolivia</td>
      <td>22</td>
      <td>5</td>
      <td>97.0</td>
      <td>86.7</td>
      <td>3810.0</td>
      <td>95.0</td>
      <td>94.0</td>
      <td>9354.0</td>
    </tr>
    <tr>
      <th>22</th>
      <td>Bosnia and Herzegovina</td>
      <td>23</td>
      <td>2</td>
      <td>25.0</td>
      <td>96.7</td>
      <td>6780.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>3926.0</td>
    </tr>
    <tr>
      <th>23</th>
      <td>Botswana</td>
      <td>24</td>
      <td>3</td>
      <td>51.0</td>
      <td>81.2</td>
      <td>11730.0</td>
      <td>85.0</td>
      <td>83.0</td>
      <td>1858.0</td>
    </tr>
    <tr>
      <th>24</th>
      <td>Brazil</td>
      <td>25</td>
      <td>5</td>
      <td>71.0</td>
      <td>88.6</td>
      <td>8700.0</td>
      <td>95.0</td>
      <td>93.0</td>
      <td>189323.0</td>
    </tr>
    <tr>
      <th>25</th>
      <td>Brunei Darussalam</td>
      <td>26</td>
      <td>6</td>
      <td>31.0</td>
      <td>92.7</td>
      <td>49900.0</td>
      <td>94.0</td>
      <td>94.0</td>
      <td>382.0</td>
    </tr>
    <tr>
      <th>26</th>
      <td>Bulgaria</td>
      <td>27</td>
      <td>2</td>
      <td>40.0</td>
      <td>98.2</td>
      <td>10270.0</td>
      <td>92.0</td>
      <td>93.0</td>
      <td>7693.0</td>
    </tr>
    <tr>
      <th>27</th>
      <td>Burkina Faso</td>
      <td>28</td>
      <td>3</td>
      <td>131.0</td>
      <td>23.6</td>
      <td>1130.0</td>
      <td>42.0</td>
      <td>52.0</td>
      <td>14359.0</td>
    </tr>
    <tr>
      <th>28</th>
      <td>Burundi</td>
      <td>29</td>
      <td>3</td>
      <td>30.0</td>
      <td>59.3</td>
      <td>320.0</td>
      <td>73.0</td>
      <td>76.0</td>
      <td>8173.0</td>
    </tr>
    <tr>
      <th>29</th>
      <td>Cambodia</td>
      <td>30</td>
      <td>7</td>
      <td>52.0</td>
      <td>73.6</td>
      <td>1550.0</td>
      <td>89.0</td>
      <td>91.0</td>
      <td>14197.0</td>
    </tr>
    <tr>
      <th>...</th>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
    </tr>
    <tr>
      <th>172</th>
      <td>Swaziland</td>
      <td>173</td>
      <td>3</td>
      <td>73.0</td>
      <td>79.6</td>
      <td>4700.0</td>
      <td>79.0</td>
      <td>78.0</td>
      <td>1134.0</td>
    </tr>
    <tr>
      <th>173</th>
      <td>Sweden</td>
      <td>174</td>
      <td>2</td>
      <td>7.0</td>
      <td>NaN</td>
      <td>34310.0</td>
      <td>95.0</td>
      <td>95.0</td>
      <td>9078.0</td>
    </tr>
    <tr>
      <th>174</th>
      <td>Switzerland</td>
      <td>175</td>
      <td>2</td>
      <td>5.0</td>
      <td>NaN</td>
      <td>40840.0</td>
      <td>89.0</td>
      <td>89.0</td>
      <td>7455.0</td>
    </tr>
    <tr>
      <th>175</th>
      <td>Syria</td>
      <td>176</td>
      <td>1</td>
      <td>58.0</td>
      <td>80.8</td>
      <td>4110.0</td>
      <td>92.0</td>
      <td>97.0</td>
      <td>19408.0</td>
    </tr>
    <tr>
      <th>176</th>
      <td>Taiwan</td>
      <td>177</td>
      <td>6</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>177</th>
      <td>Tajikistan</td>
      <td>178</td>
      <td>2</td>
      <td>57.0</td>
      <td>99.5</td>
      <td>1560.0</td>
      <td>95.0</td>
      <td>99.0</td>
      <td>6640.0</td>
    </tr>
    <tr>
      <th>178</th>
      <td>Tanzania</td>
      <td>179</td>
      <td>3</td>
      <td>139.0</td>
      <td>69.4</td>
      <td>980.0</td>
      <td>97.0</td>
      <td>98.0</td>
      <td>39459.0</td>
    </tr>
    <tr>
      <th>179</th>
      <td>Thailand</td>
      <td>180</td>
      <td>6</td>
      <td>70.0</td>
      <td>92.6</td>
      <td>7440.0</td>
      <td>94.0</td>
      <td>94.0</td>
      <td>63444.0</td>
    </tr>
    <tr>
      <th>180</th>
      <td>Timor-Leste</td>
      <td>181</td>
      <td>6</td>
      <td>49.0</td>
      <td>NaN</td>
      <td>5100.0</td>
      <td>67.0</td>
      <td>70.0</td>
      <td>1114.0</td>
    </tr>
    <tr>
      <th>181</th>
      <td>Togo</td>
      <td>182</td>
      <td>3</td>
      <td>89.0</td>
      <td>53.2</td>
      <td>770.0</td>
      <td>75.0</td>
      <td>86.0</td>
      <td>6410.0</td>
    </tr>
    <tr>
      <th>182</th>
      <td>Tonga</td>
      <td>183</td>
      <td>6</td>
      <td>17.0</td>
      <td>98.9</td>
      <td>5470.0</td>
      <td>94.0</td>
      <td>97.0</td>
      <td>100.0</td>
    </tr>
    <tr>
      <th>183</th>
      <td>Trinidad and Tobago</td>
      <td>184</td>
      <td>5</td>
      <td>35.0</td>
      <td>98.5</td>
      <td>16800.0</td>
      <td>85.0</td>
      <td>85.0</td>
      <td>1328.0</td>
    </tr>
    <tr>
      <th>184</th>
      <td>Tunisia</td>
      <td>185</td>
      <td>1</td>
      <td>8.0</td>
      <td>74.3</td>
      <td>6490.0</td>
      <td>97.0</td>
      <td>96.0</td>
      <td>10215.0</td>
    </tr>
    <tr>
      <th>185</th>
      <td>Turkey</td>
      <td>186</td>
      <td>2</td>
      <td>51.0</td>
      <td>87.4</td>
      <td>8410.0</td>
      <td>89.0</td>
      <td>93.0</td>
      <td>73922.0</td>
    </tr>
    <tr>
      <th>186</th>
      <td>Turkmenistan</td>
      <td>187</td>
      <td>2</td>
      <td>29.0</td>
      <td>98.8</td>
      <td>3990.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>4899.0</td>
    </tr>
    <tr>
      <th>187</th>
      <td>Tuvalu</td>
      <td>188</td>
      <td>6</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>10.0</td>
    </tr>
    <tr>
      <th>188</th>
      <td>Uganda</td>
      <td>189</td>
      <td>3</td>
      <td>159.0</td>
      <td>68.1</td>
      <td>880.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>29899.0</td>
    </tr>
    <tr>
      <th>189</th>
      <td>Ukraine</td>
      <td>190</td>
      <td>2</td>
      <td>29.0</td>
      <td>99.4</td>
      <td>6110.0</td>
      <td>90.0</td>
      <td>90.0</td>
      <td>46557.0</td>
    </tr>
    <tr>
      <th>190</th>
      <td>United Arab Emirates</td>
      <td>191</td>
      <td>1</td>
      <td>37.0</td>
      <td>88.5</td>
      <td>31190.0</td>
      <td>88.0</td>
      <td>88.0</td>
      <td>4248.0</td>
    </tr>
    <tr>
      <th>191</th>
      <td>United Kingdom</td>
      <td>192</td>
      <td>2</td>
      <td>27.0</td>
      <td>NaN</td>
      <td>33650.0</td>
      <td>99.0</td>
      <td>98.0</td>
      <td>60512.0</td>
    </tr>
    <tr>
      <th>192</th>
      <td>United States of America</td>
      <td>193</td>
      <td>4</td>
      <td>43.0</td>
      <td>NaN</td>
      <td>44070.0</td>
      <td>93.0</td>
      <td>91.0</td>
      <td>302841.0</td>
    </tr>
    <tr>
      <th>193</th>
      <td>Uruguay</td>
      <td>194</td>
      <td>5</td>
      <td>64.0</td>
      <td>96.8</td>
      <td>9940.0</td>
      <td>100.0</td>
      <td>100.0</td>
      <td>3331.0</td>
    </tr>
    <tr>
      <th>194</th>
      <td>Uzbekistan</td>
      <td>195</td>
      <td>2</td>
      <td>40.0</td>
      <td>NaN</td>
      <td>2190.0</td>
      <td>78.0</td>
      <td>79.0</td>
      <td>26981.0</td>
    </tr>
    <tr>
      <th>195</th>
      <td>Vanuatu</td>
      <td>196</td>
      <td>6</td>
      <td>92.0</td>
      <td>75.5</td>
      <td>3480.0</td>
      <td>86.0</td>
      <td>88.0</td>
      <td>221.0</td>
    </tr>
    <tr>
      <th>196</th>
      <td>Venezuela</td>
      <td>197</td>
      <td>5</td>
      <td>81.0</td>
      <td>93.0</td>
      <td>10970.0</td>
      <td>91.0</td>
      <td>91.0</td>
      <td>27191.0</td>
    </tr>
    <tr>
      <th>197</th>
      <td>Vietnam</td>
      <td>198</td>
      <td>6</td>
      <td>25.0</td>
      <td>90.3</td>
      <td>2310.0</td>
      <td>91.0</td>
      <td>96.0</td>
      <td>86206.0</td>
    </tr>
    <tr>
      <th>198</th>
      <td>West Bank and Gaza</td>
      <td>199</td>
      <td>1</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>199</th>
      <td>Yemen</td>
      <td>200</td>
      <td>1</td>
      <td>83.0</td>
      <td>54.1</td>
      <td>2090.0</td>
      <td>65.0</td>
      <td>85.0</td>
      <td>21732.0</td>
    </tr>
    <tr>
      <th>200</th>
      <td>Zambia</td>
      <td>201</td>
      <td>3</td>
      <td>161.0</td>
      <td>68.0</td>
      <td>1140.0</td>
      <td>94.0</td>
      <td>90.0</td>
      <td>11696.0</td>
    </tr>
    <tr>
      <th>201</th>
      <td>Zimbabwe</td>
      <td>202</td>
      <td>3</td>
      <td>101.0</td>
      <td>89.5</td>
      <td>NaN</td>
      <td>88.0</td>
      <td>87.0</td>
      <td>13228.0</td>
    </tr>
  </tbody>
</table>
<p>202 rows × 9 columns</p>
</div>




```python
print("Shape",df.shape) #행/열 =튜플로 리턴
print("Length",len(df)) #데이터길이 = 행
```

    Shape (202, 9)
    Length 202
    


```python
print("Column Headers",df.columns) #컬럼명 확인 -> 리스트로 출력
```

    Column Headers Index(['Unnamed: 0', 'CountryID', 'Continent', 'Adolescent fertility rate (%)',
           'Adult literacy rate (%)',
           'Gross national income per capita (PPP international $)',
           'Net primary school enrolment ratio female (%)',
           'Net primary school enrolment ratio male (%)',
           'Population (in thousands) total'],
          dtype='object')
    


```python
print("Data types",df.dtypes) #데이터타입 확인
```

    Data types Unnamed: 0                                                 object
    CountryID                                                   int64
    Continent                                                   int64
    Adolescent fertility rate (%)                             float64
    Adult literacy rate (%)                                   float64
    Gross national income per capita (PPP international $)    float64
    Net primary school enrolment ratio female (%)             float64
    Net primary school enrolment ratio male (%)               float64
    Population (in thousands) total                           float64
    dtype: object
    


```python
print("Index",df.index) #df에 인덱스 존재 0부터 202
```

    Index RangeIndex(start=0, stop=202, step=1)
    


```python
print("Values",df.values) #값 추출
```

    Values [['Afghanistan' 1 1 ... nan nan 26088.0]
     ['Albania' 2 2 ... 93.0 94.0 3172.0]
     ['Algeria' 3 3 ... 94.0 96.0 33351.0]
     ...
     ['Yemen' 200 1 ... 65.0 85.0 21732.0]
     ['Zambia' 201 3 ... 94.0 90.0 11696.0]
     ['Zimbabwe' 202 3 ... 88.0 87.0 13228.0]]
    


```python
#PANDAS Series
```


```python
country_col = df["Country"]
print("Type df",type(df)) 
#type= 객체 df=인스턴스 :그형태에 맞춘 결과물<-클래스: 형태 /
print("Type country col",type(country_col)) #df타입이 시리즈 타입으로 반환
```

    Type df <class 'pandas.core.frame.DataFrame'>
    Type country col <class 'pandas.core.series.Series'>
    


```python
#데이터 타입인 시리즈 인 country_col 에 대한 구조 
print("Series shape:\n", country_col.shape, "\n")
print("Series index:\n", country_col.index, "\n")
print("Series values:\n", country_col.values, "\n")
print("Series name:\n", country_col.name, "\n")
```

    Series shape:
     (202,) 
    
    Series index:
     RangeIndex(start=0, stop=202, step=1) 
    
    Series values:
     ['Afghanistan' 'Albania' 'Algeria' 'Andorra' 'Angola'
     'Antigua and Barbuda' 'Argentina' 'Armenia' 'Australia' 'Austria'
     'Azerbaijan' 'Bahamas' 'Bahrain' 'Bangladesh' 'Barbados' 'Belarus'
     'Belgium' 'Belize' 'Benin' 'Bermuda' 'Bhutan' 'Bolivia'
     'Bosnia and Herzegovina' 'Botswana' 'Brazil' 'Brunei Darussalam'
     'Bulgaria' 'Burkina Faso' 'Burundi' 'Cambodia' 'Cameroon' 'Canada'
     'Cape Verde' 'Central African Republic' 'Chad' 'Chile' 'China' 'Colombia'
     'Comoros' 'Congo, Dem. Rep.' 'Congo, Rep.' 'Cook Islands' 'Costa Rica'
     "Cote d'Ivoire" 'Croatia' 'Cuba' 'Cyprus' 'Czech Republic' 'Denmark'
     'Djibouti' 'Dominica' 'Dominican Republic' 'Ecuador' 'Egypt'
     'El Salvador' 'Equatorial Guinea' 'Eritrea' 'Estonia' 'Ethiopia' 'Fiji'
     'Finland' 'France' 'French Polynesia' 'Gabon' 'Gambia' 'Georgia'
     'Germany' 'Ghana' 'Greece' 'Grenada' 'Guatemala' 'Guinea' 'Guinea-Bissau'
     'Guyana' 'Haiti' 'Honduras' 'Hong Kong, China' 'Hungary' 'Iceland'
     'India' 'Indonesia' 'Iran (Islamic Republic of)' 'Iraq' 'Ireland'
     'Israel' 'Italy' 'Jamaica' 'Japan' 'Jordan' 'Kazakhstan' 'Kenya'
     'Kiribati' 'Korea, Dem. Rep.' 'Korea, Rep.' 'Kuwait' 'Kyrgyzstan'
     "Lao People's Democratic Republic" 'Latvia' 'Lebanon' 'Lesotho' 'Liberia'
     'Libyan Arab Jamahiriya' 'Lithuania' 'Luxembourg' 'Macao, China'
     'Macedonia' 'Madagascar' 'Malawi' 'Malaysia' 'Maldives' 'Mali' 'Malta'
     'Marshall Islands' 'Mauritania' 'Mauritius' 'Mexico'
     'Micronesia (Federated States of)' 'Moldova' 'Monaco' 'Mongolia'
     'Montenegro' 'Morocco' 'Mozambique' 'Myanmar' 'Namibia' 'Nauru' 'Nepal'
     'Netherlands' 'Netherlands Antilles' 'New Caledonia' 'New Zealand'
     'Nicaragua' 'Niger' 'Nigeria' 'Niue' 'Norway' 'Oman' 'Pakistan' 'Palau'
     'Panama' 'Papua New Guinea' 'Paraguay' 'Peru' 'Philippines' 'Poland'
     'Portugal' 'Puerto Rico' 'Qatar' 'Romania' 'Russia' 'Rwanda'
     'Saint Kitts and Nevis' 'Saint Lucia' 'Saint Vincent and the Grenadines'
     'Samoa' 'San Marino' 'Sao Tome and Principe' 'Saudi Arabia' 'Senegal'
     'Serbia' 'Seychelles' 'Sierra Leone' 'Singapore' 'Slovakia' 'Slovenia'
     'Solomon Islands' 'Somalia' 'South Africa' 'Spain' 'Sri Lanka' 'Sudan'
     'Suriname' 'Swaziland' 'Sweden' 'Switzerland' 'Syria' 'Taiwan'
     'Tajikistan' 'Tanzania' 'Thailand' 'Timor-Leste' 'Togo' 'Tonga'
     'Trinidad and Tobago' 'Tunisia' 'Turkey' 'Turkmenistan' 'Tuvalu' 'Uganda'
     'Ukraine' 'United Arab Emirates' 'United Kingdom'
     'United States of America' 'Uruguay' 'Uzbekistan' 'Vanuatu' 'Venezuela'
     'Vietnam' 'West Bank and Gaza' 'Yemen' 'Zambia' 'Zimbabwe'] 
    
    Series name:
     Country 
    
    


```python
#슬라이싱 
print("Last 2 countries:\n", country_col[-2:], "\n")
print("Last 2 countries type:\n", type(country_col[-2:]), "\n")
```

    Last 2 countries:
     200      Zambia
    201    Zimbabwe
    Name: Country, dtype: object 
    
    Last 2 countries type:
     <class 'pandas.core.series.Series'> 
    
    


```python
#NP 사용 in Pandas - sign(): 양수:1, 음수 -1 ,0이면 0
last_col = df.columns[-1] #마지막 컬럼= 인구수
print("Last df column signs:\n", last_col, np.sign(df[last_col]), "\n") 
#sign:+/-부호
```

    Last df column signs:
     Population (in thousands) total 0      1.0
    1      1.0
    2      1.0
    3      1.0
    4      1.0
    5      1.0
    6      1.0
    7      1.0
    8      1.0
    9      1.0
    10     1.0
    11     1.0
    12     1.0
    13     1.0
    14     1.0
    15     1.0
    16     1.0
    17     1.0
    18     1.0
    19     NaN
    20     1.0
    21     1.0
    22     1.0
    23     1.0
    24     1.0
    25     1.0
    26     1.0
    27     1.0
    28     1.0
    29     1.0
          ... 
    172    1.0
    173    1.0
    174    1.0
    175    1.0
    176    NaN
    177    1.0
    178    1.0
    179    1.0
    180    1.0
    181    1.0
    182    1.0
    183    1.0
    184    1.0
    185    1.0
    186    1.0
    187    1.0
    188    1.0
    189    1.0
    190    1.0
    191    1.0
    192    1.0
    193    1.0
    194    1.0
    195    1.0
    196    1.0
    197    1.0
    198    NaN
    199    1.0
    200    1.0
    201    1.0
    Name: Population (in thousands) total, Length: 202, dtype: float64 
    
    

    C:\Users\hyun kyoung oh\Anaconda3\lib\site-packages\ipykernel_launcher.py:3: RuntimeWarning: invalid value encountered in sign
      This is separate from the ipykernel package so we can avoid doing imports until
    




    'Population (in thousands) total'




```python
np.sum([0,np.nan]) #인덱스 0 에 nan
```




    nan




```python
df.dtypes
```




    Country                                                    object
    CountryID                                                   int64
    Continent                                                   int64
    Adolescent fertility rate (%)                             float64
    Adult literacy rate (%)                                   float64
    Gross national income per capita (PPP international $)    float64
    Net primary school enrolment ratio female (%)             float64
    Net primary school enrolment ratio male (%)               float64
    Population (in thousands) total                           float64
    dtype: object




```python
print(np.sum(df[last_col]-df[last_col].values)) #같은값
#poptotal - #df['변수명'].values : 시리즈에서 특정값 추출
```

    0.0
    




    array([2.608800e+04, 3.172000e+03, 3.335100e+04, 7.400000e+01,
           1.655700e+04, 8.400000e+01, 3.913400e+04, 3.010000e+03,
           2.053000e+04, 8.327000e+03, 8.406000e+03, 3.270000e+02,
           7.390000e+02, 1.559910e+05, 2.930000e+02, 9.742000e+03,
           1.043000e+04, 2.820000e+02, 8.760000e+03,          nan,
           6.490000e+02, 9.354000e+03, 3.926000e+03, 1.858000e+03,
           1.893230e+05, 3.820000e+02, 7.693000e+03, 1.435900e+04,
           8.173000e+03, 1.419700e+04, 1.817500e+04, 3.257700e+04,
           5.190000e+02, 4.265000e+03, 1.046800e+04, 1.646500e+04,
           1.328474e+06, 4.555800e+04, 8.180000e+02,          nan,
                    nan, 1.400000e+01, 4.399000e+03, 1.891400e+04,
           4.556000e+03, 1.126700e+04, 8.460000e+02, 1.018900e+04,
           5.430000e+03, 8.190000e+02, 6.800000e+01, 9.615000e+03,
           1.320200e+04, 7.416600e+04, 6.762000e+03, 4.960000e+02,
           4.692000e+03, 1.340000e+03, 8.102100e+04, 8.330000e+02,
           5.261000e+03, 6.133000e+04,          nan, 1.311000e+03,
           1.663000e+03, 4.433000e+03, 8.264100e+04, 2.300800e+04,
           1.112300e+04, 1.060000e+02, 1.302900e+04, 9.181000e+03,
           1.646000e+03, 7.390000e+02, 9.446000e+03, 6.969000e+03,
                    nan, 1.005800e+04, 2.980000e+02, 1.151751e+06,
           2.288640e+05, 7.027000e+04, 2.850600e+04, 4.221000e+03,
           6.810000e+03, 5.877900e+04, 2.699000e+03, 1.279530e+05,
           5.729000e+03, 1.531400e+04, 3.655300e+04, 9.400000e+01,
                    nan,          nan, 2.779000e+03, 5.259000e+03,
           5.759000e+03, 2.289000e+03, 4.055000e+03, 1.995000e+03,
           3.579000e+03, 6.039000e+03, 3.408000e+03, 4.610000e+02,
                    nan, 2.036000e+03, 1.915900e+04, 1.357100e+04,
           2.611400e+04, 3.000000e+02, 1.196800e+04, 4.050000e+02,
           5.800000e+01, 3.044000e+03, 1.252000e+03, 1.053420e+05,
           1.110000e+02, 3.833000e+03, 3.300000e+01, 2.605000e+03,
           6.010000e+02, 3.085300e+04, 2.097100e+04, 4.837900e+04,
           2.047000e+03, 1.000000e+01, 2.764100e+04, 1.637900e+04,
                    nan,          nan, 4.140000e+03, 5.532000e+03,
           1.373700e+04, 1.447200e+05, 2.000000e+00, 4.669000e+03,
           2.546000e+03, 1.609430e+05, 2.000000e+01, 3.288000e+03,
           6.202000e+03, 6.016000e+03, 2.758900e+04, 8.626400e+04,
           3.814000e+04, 1.057900e+04,          nan, 8.210000e+02,
           2.153200e+04, 1.432210e+05, 9.464000e+03, 5.000000e+01,
           1.630000e+02, 1.200000e+02, 1.850000e+02, 3.100000e+01,
           1.550000e+02, 2.417500e+04, 1.207200e+04, 9.851000e+03,
           8.600000e+01, 5.743000e+03, 4.382000e+03, 5.388000e+03,
           2.001000e+03, 4.840000e+02, 8.445000e+03, 4.828200e+04,
           4.388700e+04, 1.920700e+04, 3.770700e+04, 4.550000e+02,
           1.134000e+03, 9.078000e+03, 7.455000e+03, 1.940800e+04,
                    nan, 6.640000e+03, 3.945900e+04, 6.344400e+04,
           1.114000e+03, 6.410000e+03, 1.000000e+02, 1.328000e+03,
           1.021500e+04, 7.392200e+04, 4.899000e+03, 1.000000e+01,
           2.989900e+04, 4.655700e+04, 4.248000e+03, 6.051200e+04,
           3.028410e+05, 3.331000e+03, 2.698100e+04, 2.210000e+02,
           2.719100e+04, 8.620600e+04,          nan, 2.173200e+04,
           1.169600e+04, 1.322800e+04])




```python
#Querying Data in pandas
import quandl
```


```python
sunspots=quandl.get("SIDC/SUNSPOTS_A")
```


```python
type(sunspots) #확인
```




    pandas.core.frame.DataFrame




```python
#print("Head 2:\n",sunspots.head(2))
sunspots.head(2) 
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Yearly Mean Total Sunspot Number</th>
      <th>Yearly Mean Standard Deviation</th>
      <th>Number of Observations</th>
      <th>Definitive/Provisional Indicator</th>
    </tr>
    <tr>
      <th>Date</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>1700-12-31</th>
      <td>8.3</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>1701-12-31</th>
      <td>18.3</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>1.0</td>
    </tr>
  </tbody>
</table>
</div>




```python
print("Tail 2:\n",sunspots.tail(2))
```

    Tail 2:
                 Yearly Mean Total Sunspot Number  Yearly Mean Standard Deviation  \
    Date                                                                           
    2017-12-31                              21.7                             2.5   
    2018-12-31                               7.0                             1.1   
    
                Number of Observations  Definitive/Provisional Indicator  
    Date                                                                  
    2017-12-31                 11444.0                               1.0  
    2018-12-31                 12611.0                               1.0  
    


```python
last_date = sunspots.index[-1]
print("Last value:\n",sunspots.loc[last_date])
```

    Last value:
     Yearly Mean Total Sunspot Number        7.0
    Yearly Mean Standard Deviation          1.1
    Number of Observations              12611.0
    Definitive/Provisional Indicator        1.0
    Name: 2018-12-31 00:00:00, dtype: float64
    


```python
print("Values slice by date:\n", sunspots["20020101": "20131231"])
```

    Values slice by date:
                 Yearly Mean Total Sunspot Number  Yearly Mean Standard Deviation  \
    Date                                                                           
    2002-12-31                             163.6                             9.8   
    2003-12-31                              99.3                             7.1   
    2004-12-31                              65.3                             5.9   
    2005-12-31                              45.8                             4.7   
    2006-12-31                              24.7                             3.5   
    2007-12-31                              12.6                             2.7   
    2008-12-31                               4.2                             2.5   
    2009-12-31                               4.8                             2.5   
    2010-12-31                              24.9                             3.4   
    2011-12-31                              80.8                             6.7   
    2012-12-31                              84.5                             6.7   
    2013-12-31                              94.0                             6.9   
    
                Number of Observations  Definitive/Provisional Indicator  
    Date                                                                  
    2002-12-31                  6588.0                               1.0  
    2003-12-31                  7087.0                               1.0  
    2004-12-31                  6882.0                               1.0  
    2005-12-31                  7084.0                               1.0  
    2006-12-31                  6370.0                               1.0  
    2007-12-31                  6841.0                               1.0  
    2008-12-31                  6644.0                               1.0  
    2009-12-31                  6465.0                               1.0  
    2010-12-31                  6328.0                               1.0  
    2011-12-31                  6077.0                               1.0  
    2012-12-31                  5753.0                               1.0  
    2013-12-31                  5347.0                               1.0  
    


```python
print("Slice from a list of indices:\n", sunspots.iloc[[2, 4, -4, -2]])
```

    Slice from a list of indices:
                 Yearly Mean Total Sunspot Number  Yearly Mean Standard Deviation  \
    Date                                                                           
    1702-12-31                              26.7                             NaN   
    1704-12-31                              60.0                             NaN   
    2015-12-31                              69.8                             6.4   
    2017-12-31                              21.7                             2.5   
    
                Number of Observations  Definitive/Provisional Indicator  
    Date                                                                  
    1702-12-31                     NaN                               1.0  
    1704-12-31                     NaN                               1.0  
    2015-12-31                  8903.0                               1.0  
    2017-12-31                 11444.0                               1.0  
    


```python
print("Scalar with Iloc:", sunspots.iloc[0, 0])
print("Scalar with iat", sunspots.iat[1, 0])
```

    Scalar with Iloc: 8.3
    Scalar with iat 18.3
    


```python
sunspots > sunspots.mean() #T/F 로나옴
#sunspots[sunspots > sunspots.mean()] #NaN 으로 나옴 false
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Yearly Mean Total Sunspot Number</th>
      <th>Yearly Mean Standard Deviation</th>
      <th>Number of Observations</th>
      <th>Definitive/Provisional Indicator</th>
    </tr>
    <tr>
      <th>Date</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>1700-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1701-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1702-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1703-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1704-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1705-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1706-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1707-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1708-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1709-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1710-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1711-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1712-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1713-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1714-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1715-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1716-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1717-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1718-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1719-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1720-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1721-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1722-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1723-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1724-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1725-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1726-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1727-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1728-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1729-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>...</th>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
    </tr>
    <tr>
      <th>1989-12-31</th>
      <td>True</td>
      <td>True</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1990-12-31</th>
      <td>True</td>
      <td>True</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1991-12-31</th>
      <td>True</td>
      <td>True</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1992-12-31</th>
      <td>True</td>
      <td>True</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1993-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1994-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1995-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1996-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1997-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1998-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1999-12-31</th>
      <td>True</td>
      <td>True</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2000-12-31</th>
      <td>True</td>
      <td>True</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2001-12-31</th>
      <td>True</td>
      <td>True</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2002-12-31</th>
      <td>True</td>
      <td>True</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2003-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2004-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2005-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2006-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2007-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2008-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2009-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2010-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2011-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2012-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2013-12-31</th>
      <td>True</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2014-12-31</th>
      <td>True</td>
      <td>True</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2015-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2016-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2017-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2018-12-31</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
      <td>False</td>
    </tr>
  </tbody>
</table>
<p>319 rows × 4 columns</p>
</div>




```python
print("Boolean selection with column label:\n", sunspots[sunspots['Number of Observations'] > sunspots['Number of Observations'].mean()])
```

    Boolean selection with column label:
                 Yearly Mean Total Sunspot Number  Yearly Mean Standard Deviation  \
    Date                                                                           
    1981-12-31                             198.9                            13.1   
    1982-12-31                             162.4                            12.1   
    1983-12-31                              91.0                             7.6   
    1984-12-31                              60.5                             5.9   
    1985-12-31                              20.6                             3.7   
    1986-12-31                              14.8                             3.5   
    1987-12-31                              33.9                             3.7   
    1988-12-31                             123.0                             8.4   
    1989-12-31                             211.1                            12.8   
    1990-12-31                             191.8                            11.2   
    1991-12-31                             203.3                            12.7   
    1992-12-31                             133.0                             8.9   
    1993-12-31                              76.1                             5.8   
    1994-12-31                              44.9                             4.4   
    1995-12-31                              25.1                             3.7   
    1996-12-31                              11.6                             3.1   
    1997-12-31                              28.9                             3.6   
    1998-12-31                              88.3                             6.6   
    1999-12-31                             136.3                             9.3   
    2000-12-31                             173.9                            10.1   
    2001-12-31                             170.4                            10.5   
    2002-12-31                             163.6                             9.8   
    2003-12-31                              99.3                             7.1   
    2004-12-31                              65.3                             5.9   
    2005-12-31                              45.8                             4.7   
    2006-12-31                              24.7                             3.5   
    2007-12-31                              12.6                             2.7   
    2008-12-31                               4.2                             2.5   
    2009-12-31                               4.8                             2.5   
    2010-12-31                              24.9                             3.4   
    2011-12-31                              80.8                             6.7   
    2012-12-31                              84.5                             6.7   
    2013-12-31                              94.0                             6.9   
    2014-12-31                             113.3                             8.0   
    2015-12-31                              69.8                             6.4   
    2016-12-31                              39.8                             3.9   
    2017-12-31                              21.7                             2.5   
    2018-12-31                               7.0                             1.1   
    
                Number of Observations  Definitive/Provisional Indicator  
    Date                                                                  
    1981-12-31                  3049.0                               1.0  
    1982-12-31                  3436.0                               1.0  
    1983-12-31                  4216.0                               1.0  
    1984-12-31                  5103.0                               1.0  
    1985-12-31                  5543.0                               1.0  
    1986-12-31                  5934.0                               1.0  
    1987-12-31                  6396.0                               1.0  
    1988-12-31                  6556.0                               1.0  
    1989-12-31                  6932.0                               1.0  
    1990-12-31                  7108.0                               1.0  
    1991-12-31                  6932.0                               1.0  
    1992-12-31                  7845.0                               1.0  
    1993-12-31                  8010.0                               1.0  
    1994-12-31                  8524.0                               1.0  
    1995-12-31                  8429.0                               1.0  
    1996-12-31                  7614.0                               1.0  
    1997-12-31                  7294.0                               1.0  
    1998-12-31                  6353.0                               1.0  
    1999-12-31                  6413.0                               1.0  
    2000-12-31                  5953.0                               1.0  
    2001-12-31                  6558.0                               1.0  
    2002-12-31                  6588.0                               1.0  
    2003-12-31                  7087.0                               1.0  
    2004-12-31                  6882.0                               1.0  
    2005-12-31                  7084.0                               1.0  
    2006-12-31                  6370.0                               1.0  
    2007-12-31                  6841.0                               1.0  
    2008-12-31                  6644.0                               1.0  
    2009-12-31                  6465.0                               1.0  
    2010-12-31                  6328.0                               1.0  
    2011-12-31                  6077.0                               1.0  
    2012-12-31                  5753.0                               1.0  
    2013-12-31                  5347.0                               1.0  
    2014-12-31                  5273.0                               1.0  
    2015-12-31                  8903.0                               1.0  
    2016-12-31                  9940.0                               1.0  
    2017-12-31                 11444.0                               1.0  
    2018-12-31                 12611.0                               1.0  
    


```python
#Statistics with pandas DataFrame
import quandl
```


```python
sunspots = quandl.get("SIDC/SUNSPOTS_A")
sunspots.describe() #다 보기 편함
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Yearly Mean Total Sunspot Number</th>
      <th>Yearly Mean Standard Deviation</th>
      <th>Number of Observations</th>
      <th>Definitive/Provisional Indicator</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>count</th>
      <td>319.000000</td>
      <td>201.000000</td>
      <td>201.000000</td>
      <td>319.0</td>
    </tr>
    <tr>
      <th>mean</th>
      <td>78.970533</td>
      <td>7.947761</td>
      <td>1572.751244</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>std</th>
      <td>62.019871</td>
      <td>3.840522</td>
      <td>2667.888556</td>
      <td>0.0</td>
    </tr>
    <tr>
      <th>min</th>
      <td>0.000000</td>
      <td>1.100000</td>
      <td>150.000000</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>25%</th>
      <td>24.800000</td>
      <td>4.700000</td>
      <td>365.000000</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>50%</th>
      <td>65.800000</td>
      <td>7.600000</td>
      <td>365.000000</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>75%</th>
      <td>115.750000</td>
      <td>10.400000</td>
      <td>366.000000</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>max</th>
      <td>269.300000</td>
      <td>19.100000</td>
      <td>12611.000000</td>
      <td>1.0</td>
    </tr>
  </tbody>
</table>
</div>




```python
#Data Aggregation
import pandas as pd
from numpy.random import seed
from numpy.random import rand
from numpy.random import randint
import numpy as np
```


```python
seed(42) #고정 랜덤 난수
```


```python
df = pd.DataFrame(
    {'Weather' : ['cold', 'hot', 'cold', 'hot','cold', 'hot', 'cold'],
   'Food' : ['soup', 'soup', 'icecream', 'chocolate','icecream', 'icecream', 'soup'],
   'Price' : 10 * rand(7), 
    'Number' : randint(1, 9)}
)
print(df)
```

      Weather       Food     Price  Number
    0    cold       soup  3.745401       8
    1     hot       soup  9.507143       8
    2    cold   icecream  7.319939       8
    3     hot  chocolate  5.986585       8
    4    cold   icecream  1.560186       8
    5     hot   icecream  1.559945       8
    6    cold       soup  0.580836       8
    


```python
weather_group=df.groupby('Weather') #그룹화
#weather_group ->DATAFRAMEGROUPBY 타입임 
i=0
for name, group in weather_group: 
    i=i+1
    print("Group",i,name) 
    print(group)
    
#각 데이터는 dataframe으로 됨
```

    Group 1 cold
      Weather      Food     Price  Number
    0    cold      soup  3.745401       8
    2    cold  icecream  7.319939       8
    4    cold  icecream  1.560186       8
    6    cold      soup  0.580836       8
    Group 2 hot
      Weather       Food     Price  Number
    1     hot       soup  9.507143       8
    3     hot  chocolate  5.986585       8
    5     hot   icecream  1.559945       8
    


```python
#각 그룹 첫번째행, 마지막 행, 평균 출력
print("Weather group first\n", weather_group.first())
print("Weather group last\n", weather_group.last())
print("Weather group mean\n", weather_group.mean())
```

    Weather group first
              Food     Price  Number
    Weather                        
    cold     soup  3.745401       8
    hot      soup  9.507143       8
    Weather group last
                  Food     Price  Number
    Weather                            
    cold         soup  0.580836       8
    hot      icecream  1.559945       8
    Weather group mean
                 Price  Number
    Weather                  
    cold     3.301591       8
    hot      5.684558       8
    


```python
wf_group=df.groupby(['Weather','Food'])
#print("WF Groups",wf_group.groups)
#테스트로 i를 다시 0부터해서 볼때 , enumerate로 계산
for i,(name, group) in enumerate(weather_group):
    i=i+1
    print("Group",i,name) 
    print(group)
```

    Group 1 cold
      Weather      Food     Price  Number
    0    cold      soup  3.745401       8
    2    cold  icecream  7.319939       8
    4    cold  icecream  1.560186       8
    6    cold      soup  0.580836       8
    Group 2 hot
      Weather       Food     Price  Number
    1     hot       soup  9.507143       8
    3     hot  chocolate  5.986585       8
    5     hot   icecream  1.559945       8
    


```python
print("WF Aggregated\n",wf_group.agg([np.mean,np.median]))
#agg() = apply() 적용
#np.mean 함수 / np.mean() 함수값
#agg(함수) : 함수를 받는 함수 / 한번에 여러개 받음
```

    WF Aggregated
                           Price           Number       
                           mean    median   mean median
    Weather Food                                       
    cold    icecream   4.440063  4.440063      8      8
            soup       2.163119  2.163119      8      8
    hot     chocolate  5.986585  5.986585      8      8
            icecream   1.559945  1.559945      8      8
            soup       9.507143  9.507143      8      8
    


```python
#Concatenating and appending DataFrames
```


```python
print("df :3\n", df[:3])
```

    df :3
       Weather      Food     Price  Number
    0    cold      soup  6.075449       5
    1     hot      soup  1.705241       5
    2    cold  icecream  0.650516       5
    


```python
print("Concat Back together\n", pd.concat([df[:3], df[3:]]))
```

    Concat Back together
       Weather       Food     Price  Number
    0    cold       soup  6.075449       5
    1     hot       soup  1.705241       5
    2    cold   icecream  0.650516       5
    3     hot  chocolate  9.488855       5
    4    cold   icecream  9.656320       5
    5     hot   icecream  8.083973       5
    6    cold       soup  3.046138       5
    


```python
print("Appending rows\n", df[:3].append(df[5:])) #인덱스!!! a부터 b전까지
```

    Appending rows
       Weather      Food     Price  Number
    0    cold      soup  6.075449       5
    1     hot      soup  1.705241       5
    2    cold  icecream  0.650516       5
    5     hot  icecream  8.083973       5
    6    cold      soup  3.046138       5
    


```python
#Joining DataFrames
```


```python
dests=pd.read_csv('dest.csv')
print("Dests\n",dests)
```

    Dests
        EmpNr       Dest
    0      5  The Hague
    1      3  Amsterdam
    2      9  Rotterdam
    


```python
tips=pd.read_csv('tips.csv')
print("Tips\n",tips)
```

    Tips
        EmpNr  Amount
    0      5    10.0
    1      9     5.0
    2      7     2.5
    


```python
#merge 기준on='', 같은 값만
pd.merge(dests,tips,on='EmpNr')
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>EmpNr</th>
      <th>Dest</th>
      <th>Amount</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>5</td>
      <td>The Hague</td>
      <td>10.0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>9</td>
      <td>Rotterdam</td>
      <td>5.0</td>
    </tr>
  </tbody>
</table>
</div>




```python
#dest기준으로 tips가 그대로 붙음 suffix left/right 위치
dests.join(tips,lsuffix='Dest',rsuffix='Tips')
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>EmpNrDest</th>
      <th>Dest</th>
      <th>EmpNrTips</th>
      <th>Amount</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>5</td>
      <td>The Hague</td>
      <td>5</td>
      <td>10.0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>3</td>
      <td>Amsterdam</td>
      <td>9</td>
      <td>5.0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>9</td>
      <td>Rotterdam</td>
      <td>7</td>
      <td>2.5</td>
    </tr>
  </tbody>
</table>
</div>




```python
#inner join
print("Inner join with merge()\n",pd.merge(dests,tips,how='inner'))
```

    Inner join with merge()
        EmpNr       Dest  Amount
    0      5  The Hague    10.0
    1      9  Rotterdam     5.0
    


```python
#full outer join with NAN
print("Inner join with merge()\n",pd.merge(dests,tips,how='outer'))
```

    Inner join with merge()
        EmpNr       Dest  Amount
    0      5  The Hague    10.0
    1      3  Amsterdam     NaN
    2      9  Rotterdam     5.0
    3      7        NaN     2.5
    


```python
#Handling missing values 누락된거 처리하기
df = pd.read_csv('WHO_first9cols.csv')
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Country</th>
      <th>CountryID</th>
      <th>Continent</th>
      <th>Adolescent fertility rate (%)</th>
      <th>Adult literacy rate (%)</th>
      <th>Gross national income per capita (PPP international $)</th>
      <th>Net primary school enrolment ratio female (%)</th>
      <th>Net primary school enrolment ratio male (%)</th>
      <th>Population (in thousands) total</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>Afghanistan</td>
      <td>1</td>
      <td>1</td>
      <td>151.0</td>
      <td>28.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>26088.0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Albania</td>
      <td>2</td>
      <td>2</td>
      <td>27.0</td>
      <td>98.7</td>
      <td>6000.0</td>
      <td>93.0</td>
      <td>94.0</td>
      <td>3172.0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Algeria</td>
      <td>3</td>
      <td>3</td>
      <td>6.0</td>
      <td>69.9</td>
      <td>5940.0</td>
      <td>94.0</td>
      <td>96.0</td>
      <td>33351.0</td>
    </tr>
    <tr>
      <th>3</th>
      <td>Andorra</td>
      <td>4</td>
      <td>2</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>83.0</td>
      <td>83.0</td>
      <td>74.0</td>
    </tr>
    <tr>
      <th>4</th>
      <td>Angola</td>
      <td>5</td>
      <td>3</td>
      <td>146.0</td>
      <td>67.4</td>
      <td>3890.0</td>
      <td>49.0</td>
      <td>51.0</td>
      <td>16557.0</td>
    </tr>
    <tr>
      <th>5</th>
      <td>Antigua and Barbuda</td>
      <td>6</td>
      <td>4</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>15130.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>84.0</td>
    </tr>
    <tr>
      <th>6</th>
      <td>Argentina</td>
      <td>7</td>
      <td>5</td>
      <td>62.0</td>
      <td>97.2</td>
      <td>11670.0</td>
      <td>98.0</td>
      <td>99.0</td>
      <td>39134.0</td>
    </tr>
    <tr>
      <th>7</th>
      <td>Armenia</td>
      <td>8</td>
      <td>2</td>
      <td>30.0</td>
      <td>99.4</td>
      <td>4950.0</td>
      <td>84.0</td>
      <td>80.0</td>
      <td>3010.0</td>
    </tr>
    <tr>
      <th>8</th>
      <td>Australia</td>
      <td>9</td>
      <td>6</td>
      <td>16.0</td>
      <td>NaN</td>
      <td>33940.0</td>
      <td>97.0</td>
      <td>96.0</td>
      <td>20530.0</td>
    </tr>
    <tr>
      <th>9</th>
      <td>Austria</td>
      <td>10</td>
      <td>2</td>
      <td>14.0</td>
      <td>NaN</td>
      <td>36040.0</td>
      <td>98.0</td>
      <td>97.0</td>
      <td>8327.0</td>
    </tr>
    <tr>
      <th>10</th>
      <td>Azerbaijan</td>
      <td>11</td>
      <td>2</td>
      <td>31.0</td>
      <td>98.8</td>
      <td>5430.0</td>
      <td>83.0</td>
      <td>86.0</td>
      <td>8406.0</td>
    </tr>
    <tr>
      <th>11</th>
      <td>Bahamas</td>
      <td>12</td>
      <td>4</td>
      <td>46.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>89.0</td>
      <td>87.0</td>
      <td>327.0</td>
    </tr>
    <tr>
      <th>12</th>
      <td>Bahrain</td>
      <td>13</td>
      <td>1</td>
      <td>14.0</td>
      <td>86.5</td>
      <td>34310.0</td>
      <td>98.0</td>
      <td>98.0</td>
      <td>739.0</td>
    </tr>
    <tr>
      <th>13</th>
      <td>Bangladesh</td>
      <td>14</td>
      <td>7</td>
      <td>135.0</td>
      <td>47.5</td>
      <td>1230.0</td>
      <td>90.0</td>
      <td>87.0</td>
      <td>155991.0</td>
    </tr>
    <tr>
      <th>14</th>
      <td>Barbados</td>
      <td>15</td>
      <td>4</td>
      <td>51.0</td>
      <td>NaN</td>
      <td>15150.0</td>
      <td>96.0</td>
      <td>97.0</td>
      <td>293.0</td>
    </tr>
    <tr>
      <th>15</th>
      <td>Belarus</td>
      <td>16</td>
      <td>2</td>
      <td>22.0</td>
      <td>99.6</td>
      <td>9700.0</td>
      <td>88.0</td>
      <td>90.0</td>
      <td>9742.0</td>
    </tr>
    <tr>
      <th>16</th>
      <td>Belgium</td>
      <td>17</td>
      <td>2</td>
      <td>5.0</td>
      <td>NaN</td>
      <td>33860.0</td>
      <td>97.0</td>
      <td>97.0</td>
      <td>10430.0</td>
    </tr>
    <tr>
      <th>17</th>
      <td>Belize</td>
      <td>18</td>
      <td>5</td>
      <td>90.0</td>
      <td>70.3</td>
      <td>7080.0</td>
      <td>97.0</td>
      <td>97.0</td>
      <td>282.0</td>
    </tr>
    <tr>
      <th>18</th>
      <td>Benin</td>
      <td>19</td>
      <td>3</td>
      <td>108.0</td>
      <td>34.7</td>
      <td>1250.0</td>
      <td>73.0</td>
      <td>87.0</td>
      <td>8760.0</td>
    </tr>
    <tr>
      <th>19</th>
      <td>Bermuda</td>
      <td>20</td>
      <td>4</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>20</th>
      <td>Bhutan</td>
      <td>21</td>
      <td>7</td>
      <td>62.0</td>
      <td>NaN</td>
      <td>4000.0</td>
      <td>79.0</td>
      <td>79.0</td>
      <td>649.0</td>
    </tr>
    <tr>
      <th>21</th>
      <td>Bolivia</td>
      <td>22</td>
      <td>5</td>
      <td>97.0</td>
      <td>86.7</td>
      <td>3810.0</td>
      <td>95.0</td>
      <td>94.0</td>
      <td>9354.0</td>
    </tr>
    <tr>
      <th>22</th>
      <td>Bosnia and Herzegovina</td>
      <td>23</td>
      <td>2</td>
      <td>25.0</td>
      <td>96.7</td>
      <td>6780.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>3926.0</td>
    </tr>
    <tr>
      <th>23</th>
      <td>Botswana</td>
      <td>24</td>
      <td>3</td>
      <td>51.0</td>
      <td>81.2</td>
      <td>11730.0</td>
      <td>85.0</td>
      <td>83.0</td>
      <td>1858.0</td>
    </tr>
    <tr>
      <th>24</th>
      <td>Brazil</td>
      <td>25</td>
      <td>5</td>
      <td>71.0</td>
      <td>88.6</td>
      <td>8700.0</td>
      <td>95.0</td>
      <td>93.0</td>
      <td>189323.0</td>
    </tr>
    <tr>
      <th>25</th>
      <td>Brunei Darussalam</td>
      <td>26</td>
      <td>6</td>
      <td>31.0</td>
      <td>92.7</td>
      <td>49900.0</td>
      <td>94.0</td>
      <td>94.0</td>
      <td>382.0</td>
    </tr>
    <tr>
      <th>26</th>
      <td>Bulgaria</td>
      <td>27</td>
      <td>2</td>
      <td>40.0</td>
      <td>98.2</td>
      <td>10270.0</td>
      <td>92.0</td>
      <td>93.0</td>
      <td>7693.0</td>
    </tr>
    <tr>
      <th>27</th>
      <td>Burkina Faso</td>
      <td>28</td>
      <td>3</td>
      <td>131.0</td>
      <td>23.6</td>
      <td>1130.0</td>
      <td>42.0</td>
      <td>52.0</td>
      <td>14359.0</td>
    </tr>
    <tr>
      <th>28</th>
      <td>Burundi</td>
      <td>29</td>
      <td>3</td>
      <td>30.0</td>
      <td>59.3</td>
      <td>320.0</td>
      <td>73.0</td>
      <td>76.0</td>
      <td>8173.0</td>
    </tr>
    <tr>
      <th>29</th>
      <td>Cambodia</td>
      <td>30</td>
      <td>7</td>
      <td>52.0</td>
      <td>73.6</td>
      <td>1550.0</td>
      <td>89.0</td>
      <td>91.0</td>
      <td>14197.0</td>
    </tr>
    <tr>
      <th>...</th>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
    </tr>
    <tr>
      <th>172</th>
      <td>Swaziland</td>
      <td>173</td>
      <td>3</td>
      <td>73.0</td>
      <td>79.6</td>
      <td>4700.0</td>
      <td>79.0</td>
      <td>78.0</td>
      <td>1134.0</td>
    </tr>
    <tr>
      <th>173</th>
      <td>Sweden</td>
      <td>174</td>
      <td>2</td>
      <td>7.0</td>
      <td>NaN</td>
      <td>34310.0</td>
      <td>95.0</td>
      <td>95.0</td>
      <td>9078.0</td>
    </tr>
    <tr>
      <th>174</th>
      <td>Switzerland</td>
      <td>175</td>
      <td>2</td>
      <td>5.0</td>
      <td>NaN</td>
      <td>40840.0</td>
      <td>89.0</td>
      <td>89.0</td>
      <td>7455.0</td>
    </tr>
    <tr>
      <th>175</th>
      <td>Syria</td>
      <td>176</td>
      <td>1</td>
      <td>58.0</td>
      <td>80.8</td>
      <td>4110.0</td>
      <td>92.0</td>
      <td>97.0</td>
      <td>19408.0</td>
    </tr>
    <tr>
      <th>176</th>
      <td>Taiwan</td>
      <td>177</td>
      <td>6</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>177</th>
      <td>Tajikistan</td>
      <td>178</td>
      <td>2</td>
      <td>57.0</td>
      <td>99.5</td>
      <td>1560.0</td>
      <td>95.0</td>
      <td>99.0</td>
      <td>6640.0</td>
    </tr>
    <tr>
      <th>178</th>
      <td>Tanzania</td>
      <td>179</td>
      <td>3</td>
      <td>139.0</td>
      <td>69.4</td>
      <td>980.0</td>
      <td>97.0</td>
      <td>98.0</td>
      <td>39459.0</td>
    </tr>
    <tr>
      <th>179</th>
      <td>Thailand</td>
      <td>180</td>
      <td>6</td>
      <td>70.0</td>
      <td>92.6</td>
      <td>7440.0</td>
      <td>94.0</td>
      <td>94.0</td>
      <td>63444.0</td>
    </tr>
    <tr>
      <th>180</th>
      <td>Timor-Leste</td>
      <td>181</td>
      <td>6</td>
      <td>49.0</td>
      <td>NaN</td>
      <td>5100.0</td>
      <td>67.0</td>
      <td>70.0</td>
      <td>1114.0</td>
    </tr>
    <tr>
      <th>181</th>
      <td>Togo</td>
      <td>182</td>
      <td>3</td>
      <td>89.0</td>
      <td>53.2</td>
      <td>770.0</td>
      <td>75.0</td>
      <td>86.0</td>
      <td>6410.0</td>
    </tr>
    <tr>
      <th>182</th>
      <td>Tonga</td>
      <td>183</td>
      <td>6</td>
      <td>17.0</td>
      <td>98.9</td>
      <td>5470.0</td>
      <td>94.0</td>
      <td>97.0</td>
      <td>100.0</td>
    </tr>
    <tr>
      <th>183</th>
      <td>Trinidad and Tobago</td>
      <td>184</td>
      <td>5</td>
      <td>35.0</td>
      <td>98.5</td>
      <td>16800.0</td>
      <td>85.0</td>
      <td>85.0</td>
      <td>1328.0</td>
    </tr>
    <tr>
      <th>184</th>
      <td>Tunisia</td>
      <td>185</td>
      <td>1</td>
      <td>8.0</td>
      <td>74.3</td>
      <td>6490.0</td>
      <td>97.0</td>
      <td>96.0</td>
      <td>10215.0</td>
    </tr>
    <tr>
      <th>185</th>
      <td>Turkey</td>
      <td>186</td>
      <td>2</td>
      <td>51.0</td>
      <td>87.4</td>
      <td>8410.0</td>
      <td>89.0</td>
      <td>93.0</td>
      <td>73922.0</td>
    </tr>
    <tr>
      <th>186</th>
      <td>Turkmenistan</td>
      <td>187</td>
      <td>2</td>
      <td>29.0</td>
      <td>98.8</td>
      <td>3990.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>4899.0</td>
    </tr>
    <tr>
      <th>187</th>
      <td>Tuvalu</td>
      <td>188</td>
      <td>6</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>10.0</td>
    </tr>
    <tr>
      <th>188</th>
      <td>Uganda</td>
      <td>189</td>
      <td>3</td>
      <td>159.0</td>
      <td>68.1</td>
      <td>880.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>29899.0</td>
    </tr>
    <tr>
      <th>189</th>
      <td>Ukraine</td>
      <td>190</td>
      <td>2</td>
      <td>29.0</td>
      <td>99.4</td>
      <td>6110.0</td>
      <td>90.0</td>
      <td>90.0</td>
      <td>46557.0</td>
    </tr>
    <tr>
      <th>190</th>
      <td>United Arab Emirates</td>
      <td>191</td>
      <td>1</td>
      <td>37.0</td>
      <td>88.5</td>
      <td>31190.0</td>
      <td>88.0</td>
      <td>88.0</td>
      <td>4248.0</td>
    </tr>
    <tr>
      <th>191</th>
      <td>United Kingdom</td>
      <td>192</td>
      <td>2</td>
      <td>27.0</td>
      <td>NaN</td>
      <td>33650.0</td>
      <td>99.0</td>
      <td>98.0</td>
      <td>60512.0</td>
    </tr>
    <tr>
      <th>192</th>
      <td>United States of America</td>
      <td>193</td>
      <td>4</td>
      <td>43.0</td>
      <td>NaN</td>
      <td>44070.0</td>
      <td>93.0</td>
      <td>91.0</td>
      <td>302841.0</td>
    </tr>
    <tr>
      <th>193</th>
      <td>Uruguay</td>
      <td>194</td>
      <td>5</td>
      <td>64.0</td>
      <td>96.8</td>
      <td>9940.0</td>
      <td>100.0</td>
      <td>100.0</td>
      <td>3331.0</td>
    </tr>
    <tr>
      <th>194</th>
      <td>Uzbekistan</td>
      <td>195</td>
      <td>2</td>
      <td>40.0</td>
      <td>NaN</td>
      <td>2190.0</td>
      <td>78.0</td>
      <td>79.0</td>
      <td>26981.0</td>
    </tr>
    <tr>
      <th>195</th>
      <td>Vanuatu</td>
      <td>196</td>
      <td>6</td>
      <td>92.0</td>
      <td>75.5</td>
      <td>3480.0</td>
      <td>86.0</td>
      <td>88.0</td>
      <td>221.0</td>
    </tr>
    <tr>
      <th>196</th>
      <td>Venezuela</td>
      <td>197</td>
      <td>5</td>
      <td>81.0</td>
      <td>93.0</td>
      <td>10970.0</td>
      <td>91.0</td>
      <td>91.0</td>
      <td>27191.0</td>
    </tr>
    <tr>
      <th>197</th>
      <td>Vietnam</td>
      <td>198</td>
      <td>6</td>
      <td>25.0</td>
      <td>90.3</td>
      <td>2310.0</td>
      <td>91.0</td>
      <td>96.0</td>
      <td>86206.0</td>
    </tr>
    <tr>
      <th>198</th>
      <td>West Bank and Gaza</td>
      <td>199</td>
      <td>1</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>199</th>
      <td>Yemen</td>
      <td>200</td>
      <td>1</td>
      <td>83.0</td>
      <td>54.1</td>
      <td>2090.0</td>
      <td>65.0</td>
      <td>85.0</td>
      <td>21732.0</td>
    </tr>
    <tr>
      <th>200</th>
      <td>Zambia</td>
      <td>201</td>
      <td>3</td>
      <td>161.0</td>
      <td>68.0</td>
      <td>1140.0</td>
      <td>94.0</td>
      <td>90.0</td>
      <td>11696.0</td>
    </tr>
    <tr>
      <th>201</th>
      <td>Zimbabwe</td>
      <td>202</td>
      <td>3</td>
      <td>101.0</td>
      <td>89.5</td>
      <td>NaN</td>
      <td>88.0</td>
      <td>87.0</td>
      <td>13228.0</td>
    </tr>
  </tbody>
</table>
<p>202 rows × 9 columns</p>
</div>




```python
df = df[['Country', df.columns[-2]]][:2]
df
#df.columns[-2] 변수명 대신 
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Country</th>
      <th>Net primary school enrolment ratio male (%)</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>Afghanistan</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Albania</td>
      <td>94.0</td>
    </tr>
  </tbody>
</table>
</div>




```python
print("New df\n", df)
```

    New df
            Country  Net primary school enrolment ratio male (%)
    0  Afghanistan                                          NaN
    1      Albania                                         94.0
    


```python
print("Null Values\n", pd.isnull(df))
```

    Null Values
        Country  Net primary school enrolment ratio male (%)
    0    False                                         True
    1    False                                        False
    


```python
print("Total Null Values\n", pd.isnull(df).sum())
```

    Total Null Values
     Country                                        0
    Net primary school enrolment ratio male (%)    1
    dtype: int64
    


```python
print("Not Null Values\n", df.notnull())
```

    Not Null Values
        Country  Net primary school enrolment ratio male (%)
    0     True                                        False
    1     True                                         True
    


```python
print("Last Column Doubled\n", 2 * df[df.columns[-1]])
```

    Last Column Doubled
     0      NaN
    1    188.0
    Name: Net primary school enrolment ratio male (%), dtype: float64
    


```python
print("Last Column plus NaN\n", df[df.columns[-1]] + np.nan)
```

    Last Column plus NaN
     0   NaN
    1   NaN
    Name: Net primary school enrolment ratio male (%), dtype: float64
    


```python
print("Zero filled\n", df.fillna(0))
```

    Zero filled
            Country  Net primary school enrolment ratio male (%)
    0  Afghanistan                                          0.0
    1      Albania                                         94.0
    


```python
#dealing with dates
#pd.date_range('시작의 날짜형 문자','끝의 날짜형 문자')
#: 연속적인 날짜의 출력 / freq= 빈도수 / period: 일자
print("Data range",pd.date_range('1/1/1900',periods=42,freq='D'))
```

    Data range DatetimeIndex(['1900-01-01', '1900-01-02', '1900-01-03', '1900-01-04',
                   '1900-01-05', '1900-01-06', '1900-01-07', '1900-01-08',
                   '1900-01-09', '1900-01-10', '1900-01-11', '1900-01-12',
                   '1900-01-13', '1900-01-14', '1900-01-15', '1900-01-16',
                   '1900-01-17', '1900-01-18', '1900-01-19', '1900-01-20',
                   '1900-01-21', '1900-01-22', '1900-01-23', '1900-01-24',
                   '1900-01-25', '1900-01-26', '1900-01-27', '1900-01-28',
                   '1900-01-29', '1900-01-30', '1900-01-31', '1900-02-01',
                   '1900-02-02', '1900-02-03', '1900-02-04', '1900-02-05',
                   '1900-02-06', '1900-02-07', '1900-02-08', '1900-02-09',
                   '1900-02-10', '1900-02-11'],
                  dtype='datetime64[ns]', freq='D')
    


```python

import sys
try:
   print("Date range", pd.date_range('1/1/1677', periods=4, freq='D'))
except:
   etype, value, _ = sys.exc_info()
#오류클래스, 발생이유. 발생위치정보 = 튜플타입
   print("Error encountered", etype, value)
```

    Error encountered <class 'pandas._libs.tslibs.np_datetime.OutOfBoundsDatetime'> Out of bounds nanosecond timestamp: 1677-01-01 00:00:00
    


```python
#offset : 입력값 그대로 출력 / DateOffset :날짜 변수 받음
offset= pd.DateOffset(seconds=2 ** 33/10 **9)
mid=pd.to_datetime('1/1/1970')
#string 타입의 시간을 Timestamp형
```


```python
print("Start valid range", mid - offset)
```

    Start valid range 1969-12-31 23:59:51.410065
    


```python
print("End valid range", mid + offset)
```

    End valid range 1970-01-01 00:00:08.589935
    


```python
print("With format", pd.to_datetime(['19021112', '19031230'], format='%Y%m%d'))
```

    With format DatetimeIndex(['1902-11-12', '1903-12-30'], dtype='datetime64[ns]', freq=None)
    


```python
print("Illegal date", pd.to_datetime(['1902-11-12', 'not a date']) )
```


    ---------------------------------------------------------------------------

    TypeError                                 Traceback (most recent call last)

    ~\Anaconda3\lib\site-packages\pandas\core\arrays\datetimes.py in objects_to_datetime64ns(data, dayfirst, yearfirst, utc, errors, require_iso8601, allow_object)
       1860         try:
    -> 1861             values, tz_parsed = conversion.datetime_to_datetime64(data)
       1862             # If tzaware, these values represent unix timestamps, so we
    

    pandas/_libs/tslibs/conversion.pyx in pandas._libs.tslibs.conversion.datetime_to_datetime64()
    

    TypeError: Unrecognized value type: <class 'str'>

    
    During handling of the above exception, another exception occurred:
    

    ValueError                                Traceback (most recent call last)

    <ipython-input-68-f0e6bdbcf3c1> in <module>
    ----> 1 print("Illegal date", pd.to_datetime(['1902-11-12', 'not a date']) )
    

    ~\Anaconda3\lib\site-packages\pandas\core\tools\datetimes.py in to_datetime(arg, errors, dayfirst, yearfirst, utc, box, format, exact, unit, infer_datetime_format, origin, cache)
        607             result = _convert_and_box_cache(arg, cache_array, box, errors)
        608         else:
    --> 609             result = convert_listlike(arg, box, format)
        610     else:
        611         result = convert_listlike(np.array([arg]), box, format)[0]
    

    ~\Anaconda3\lib\site-packages\pandas\core\tools\datetimes.py in _convert_listlike_datetimes(arg, box, format, name, tz, unit, errors, infer_datetime_format, dayfirst, yearfirst, exact)
        300             arg, dayfirst=dayfirst, yearfirst=yearfirst,
        301             utc=utc, errors=errors, require_iso8601=require_iso8601,
    --> 302             allow_object=True)
        303 
        304     if tz_parsed is not None:
    

    ~\Anaconda3\lib\site-packages\pandas\core\arrays\datetimes.py in objects_to_datetime64ns(data, dayfirst, yearfirst, utc, errors, require_iso8601, allow_object)
       1864             return values.view('i8'), tz_parsed
       1865         except (ValueError, TypeError):
    -> 1866             raise e
       1867 
       1868     if tz_parsed is not None:
    

    ~\Anaconda3\lib\site-packages\pandas\core\arrays\datetimes.py in objects_to_datetime64ns(data, dayfirst, yearfirst, utc, errors, require_iso8601, allow_object)
       1855             dayfirst=dayfirst,
       1856             yearfirst=yearfirst,
    -> 1857             require_iso8601=require_iso8601
       1858         )
       1859     except ValueError as e:
    

    pandas/_libs/tslib.pyx in pandas._libs.tslib.array_to_datetime()
    

    pandas/_libs/tslib.pyx in pandas._libs.tslib.array_to_datetime()
    

    pandas/_libs/tslib.pyx in pandas._libs.tslib.array_to_datetime_object()
    

    pandas/_libs/tslib.pyx in pandas._libs.tslib.array_to_datetime_object()
    

    pandas/_libs/tslibs/parsing.pyx in pandas._libs.tslibs.parsing.parse_datetime_string()
    

    ~\Anaconda3\lib\site-packages\dateutil\parser\_parser.py in parse(timestr, parserinfo, **kwargs)
       1356         return parser(parserinfo).parse(timestr, **kwargs)
       1357     else:
    -> 1358         return DEFAULTPARSER.parse(timestr, **kwargs)
       1359 
       1360 
    

    ~\Anaconda3\lib\site-packages\dateutil\parser\_parser.py in parse(self, timestr, default, ignoretz, tzinfos, **kwargs)
        647 
        648         if res is None:
    --> 649             raise ValueError("Unknown string format:", timestr)
        650 
        651         if len(res) == 0:
    

    ValueError: ('Unknown string format:', 'not a date')



```python
print("Illegal date coerced", pd.to_datetime(['1902-11-12', 'not a date'], errors='coerce'))
#파싱이 불가한 경우 NaN(Not a Number)값으로 반환
#errors= : 'coerce' : '무시'/'raise' : ''예외'/''ignore' : ' 강제'
```

    Illegal date coerced DatetimeIndex(['1902-11-12', 'NaT'], dtype='datetime64[ns]', freq=None)
    


```python
#Pivot Tables
seed(42)
```


```python
N=7 #행
df = pd.DataFrame({
   'Weather' : ['cold', 'hot', 'cold', 'hot','cold', 'hot', 'cold'],
   'Food' : ['soup', 'soup', 'icecream', 'chocolate','icecream', 'icecream', 'soup'],
   'Price' : 10 * rand(N), 
    'Number' : randint(1, 9)})
```


```python
print("DataFrame\n", df)
df
```

    DataFrame
       Weather       Food     Price  Number
    0    cold       soup  3.337086       4
    1     hot       soup  1.428668       4
    2    cold   icecream  6.508885       4
    3     hot  chocolate  0.564116       4
    4    cold   icecream  7.219988       4
    5     hot   icecream  9.385527       4
    6    cold       soup  0.007788       4
    




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Weather</th>
      <th>Food</th>
      <th>Price</th>
      <th>Number</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>cold</td>
      <td>soup</td>
      <td>3.337086</td>
      <td>4</td>
    </tr>
    <tr>
      <th>1</th>
      <td>hot</td>
      <td>soup</td>
      <td>1.428668</td>
      <td>4</td>
    </tr>
    <tr>
      <th>2</th>
      <td>cold</td>
      <td>icecream</td>
      <td>6.508885</td>
      <td>4</td>
    </tr>
    <tr>
      <th>3</th>
      <td>hot</td>
      <td>chocolate</td>
      <td>0.564116</td>
      <td>4</td>
    </tr>
    <tr>
      <th>4</th>
      <td>cold</td>
      <td>icecream</td>
      <td>7.219988</td>
      <td>4</td>
    </tr>
    <tr>
      <th>5</th>
      <td>hot</td>
      <td>icecream</td>
      <td>9.385527</td>
      <td>4</td>
    </tr>
    <tr>
      <th>6</th>
      <td>cold</td>
      <td>soup</td>
      <td>0.007788</td>
      <td>4</td>
    </tr>
  </tbody>
</table>
</div>




```python
#pivot_table : 분석할 컬럼값으로만 데이터프레임 만듦
#(분석할데이터,columns:['']:열 인덱스 키, aggfunc=분석메서드)
print(pd.pivot_table(df, columns=['Food'], aggfunc=np.sum))
```

    Food    chocolate  icecream       soup
    Number   4.000000   12.0000  12.000000
    Price    0.564116   23.1144   4.773542
    
