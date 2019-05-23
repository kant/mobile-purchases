#!/usr/bin/env node
import 'source-map-support/register';
import cdk = require('@aws-cdk/cdk');
import { CloudformationStack } from '../lib/cloudformation-stack';

const app = new cdk.App();
new CloudformationStack(app, 'CloudformationStack');
