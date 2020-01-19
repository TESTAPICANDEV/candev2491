import pandas as pd

filepath = 'cip_standards.csv'

df = pd.read_csv(filepath)

active = df[df.Status == 'Subject to Enforcement']
print(active)

#
# active = output_df[output_df.Status == 'Subject to Enforcement']
# print(active)


# output_df['mean'] = output_df.iloc[:,4:].mean(axis=1)
#
# output_df = output_df[['Generator', 'Fuel Type', 'mean']]
#
# total = output_df['mean'].sum()
# output_df['pct'] = output_df['mean'].div(total)
#
# output_df = output_df[output_df.pct > 0]
# output_df = output_df.sort_values(by=['pct'], ascending=False)
# output_df = output_df.reset_index(drop=True)
#
# output_df.to_csv('power_generation_split.csv')