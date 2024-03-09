import pandas as pd
def Count_Digits(num):
  count = 0
  while num != 0:
    num //= 10
    count += 1
  return count

def valid_ID(ID):
  valid = 'false'
  N_Digits = Count_Digits(ID)
  ID = str(ID)
  if (ID[0:4] == '1234') and (N_Digits == 10):
    valid = 'True'    
  return valid 


# Read the excel file 
file_path = "Data Sheet.xlsx"
data = pd.read_excel(file_path, sheet_name=['Student', 'School'])

student = data['Student']
school  = data['School']

# School Table 
school.rename(columns = {'Gender (R)':'School_Gender (R)', 'Religion (R)':'School_Religion (R)', }, inplace = True) 
School_Valid_Data = school.copy()

# remove unique school_Id
School_Valid_Data = School_Valid_Data.drop_duplicates('School ID (R,U)')

# remove unique school_name
School_Valid_Data = School_Valid_Data.drop_duplicates('School Name (R, U)')

# remove NAN values
School_Valid_Data = School_Valid_Data.dropna()

# merge school table & student table
valid_data = pd.merge(student, School_Valid_Data, left_on='School ID (Ref, R)', right_on='School ID (R,U)', how ='left') 

# remove duplication
valid_data = valid_data.drop('School ID (R,U)', axis=1)

# chcek valid national ID
for i in range(len(valid_data)):
  national_ID = valid_data["National ID (R,U)"][i]
  if valid_ID(national_ID) == 'False':
    valid_data = valid_data.drop(i)

## drop school name with NAN values 
valid_data = valid_data.dropna(subset = ['National ID (R,U)', 'English First Name (R)', 'English Family Name (R)', 'Birth Country (R)', 'Nationality (R)', 'Gender (R)', 'Religion (R)', 'Nationality Category (R)', 'School Name (R, U)'])

""" if all columns are mandatory"""
# valud_data = valid_data.dropna()           

# remove duplicate national_ID
valid_data = valid_data.drop_duplicates(["National ID (R,U)"])

# remove duplicate full name
valid_data = valid_data.drop_duplicates(["English First Name (R)", "English Family Name (R)", "English Third Name", "English Fourth Name"])

# chcek that student gender match school gender if it's not mixed 
valid_data = valid_data.loc[(valid_data['School_Gender (R)'] == 'Mixed') | (valid_data['School_Gender (R)'] == valid_data['Gender (R)'])]


#Save valid data
file_name = 'Valid_data.xlsx'
valid_data.to_excel(file_name, index=False)
print('Excel Data sheet was saved successfully.')


