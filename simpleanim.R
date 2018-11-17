setwd("eclipse-workspace/run")

roles <- read.table("rolesna",header = TRUE)
len <- NROW(roles)
for(i in 1:len)
{
  title<-paste(c("NA Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(as.numeric(roles[i,]), main=title,names.arg = colnames(roles))
  Sys.sleep(.2+(1/i))
}

roles <- read.table("roleseuw",header = TRUE)
len <- NROW(roles)
for(i in 1:len)
{
  title<-paste(c("EUW Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(as.numeric(roles[i,]), main=title,names.arg = colnames(roles))
  Sys.sleep(.2+(1/i))
}

roles <- read.table("roleskr",header = TRUE)
len <- NROW(roles)
for(i in 1:len)
{
  title<-paste(c("KR Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(as.numeric(roles[i,]), main=title,names.arg = colnames(roles))
  Sys.sleep(.2+(1/i))
}

roles <- read.table("roleseun",header = TRUE)
len <- NROW(roles)
for(i in 1:len)
{
  title<-paste(c("EUN Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(as.numeric(roles[i,]), main=title,names.arg = colnames(roles))
  Sys.sleep(.2+(1/i))
}


roles <- read.table("rolesru",header = TRUE)
len <- NROW(roles)
for(i in 1:len)
{
  title<-paste(c("RU Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(as.numeric(roles[i,]), main=title,names.arg = colnames(roles))
  Sys.sleep(.2+(1/i))
}


roles <- read.table("rolesbr",header = TRUE)
len <- NROW(roles)
for(i in 1:len)
{
  title<-paste(c("BR Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(as.numeric(roles[i,]), main=title,names.arg = colnames(roles))
  Sys.sleep(.2+(1/i))
}

roles <- read.table("rolesoc",header = TRUE)
len <- NROW(roles)
for(i in 1:len)
{
  title<-paste(c("OC Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(as.numeric(roles[i,]), main=title,names.arg = colnames(roles))
  Sys.sleep(.2+(1/i))
}


roles <- read.table("rolesjp",header = TRUE)
len <- NROW(roles)
for(i in 1:len)
{
  title<-paste(c("JP Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(as.numeric(roles[i,]), main=title,names.arg = colnames(roles))
  Sys.sleep(.2+(1/i))
}


roles <- read.table("rolestr",header = TRUE)
len <- NROW(roles)
for(i in 1:len)
{
  title<-paste(c("TR Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(as.numeric(roles[i,]), main=title,names.arg = colnames(roles))
  Sys.sleep(.2+(1/i))
}

roles <- read.table("rolesla1",header = TRUE)
len <- NROW(roles)
for(i in 1:len)
{
  title<-paste(c("LA1 Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(as.numeric(roles[i,]), main=title,names.arg = colnames(roles))
  Sys.sleep(.2+(1/i))
}

roles <- read.table("rolesla2",header = TRUE)
len <- NROW(roles)
for(i in 1:len)
{
  title<-paste(c("LA2 Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(as.numeric(roles[i,]), main=title,names.arg = colnames(roles))
  Sys.sleep(.2+(1/i))
}

rolesna <- read.table("rolesna",header = TRUE)
roleseuw <- read.table("roleseuw",header = TRUE)
roleskr <- read.table("roleskr",header = TRUE)
roleseun <- read.table("roleseun",header = TRUE)
rolesbr <- read.table("rolesbr",header = TRUE)
rolesru <- read.table("rolesru",header = TRUE)
rolesoc <- read.table("rolesoc",header = TRUE)
rolesjp <- read.table("rolesjp",header = TRUE)
rolestr <- read.table("rolestr",header = TRUE)
rolesla1 <- read.table("rolesla1",header = TRUE)
rolesla2 <- read.table("rolesla2",header = TRUE)
for(i in 1:1300)
{
  total<-as.numeric(rolesna[i,])+
    as.numeric(roleseuw[i,])+
    as.numeric(roleskr[i,])+
    as.numeric(roleseun[i,])+
    as.numeric(rolesbr[i,])+
    as.numeric(rolesru[i,])+
    as.numeric(rolesoc[i,])+
    as.numeric(rolesjp[i,])+
    as.numeric(rolestr[i,])+
    as.numeric(rolesla1[i,])+
    as.numeric(rolesla2[i,])
  title<-paste(c("Across Servers Total Top", i,"Account Most Played Roles"), collapse = " ")
  barplot(total, main=title,names.arg = colnames(rolesna))
  Sys.sleep(.2+(1/i))
}
