import pandas as pd

filepath = ''

df = pd.read_csv(filepath)


output_df = df[df.Measurement == 'Output']
output_df['mean'] = output_df.iloc[:,4:].mean(axis=1)

output_df = output_df[['Generator', 'Fuel Type', 'mean']]

total = output_df['mean'].sum()
output_df['pct'] = output_df['mean'].div(total)

output_df = output_df[output_df.pct > 0]
output_df = output_df.sort_values(by=['pct'], ascending=False)
output_df = output_df.reset_index(drop=True)

output_df.to_csv('power_generation_split.csv')